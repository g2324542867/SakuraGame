const tinymceVue = {
  template: `<div>
      <textarea style="height:300px" v-model="value"></textarea>
    </div>`,
  props: ['value'],
  data() {
    return {
      flag: true
    }
  },
  watch: {
    value(val) {
      if (this.flag) {
        tinyMCE.activeEditor.setContent(val);
      }
      this.flag = true;
    }
  },
  mounted: function () {
    const component = this;
    tinymce.init({
      // 元素
      target: this.$el.children[0],
      // 可选标签
      valid_elements: `p[style],span[style],ul,ol,li,strong/b,em,h1,h2,h3,h4,h5,h6`,
      // 可选样式
      valid_style: {'*': 'color,font_size,text-align,line-height'},
      // 插件
      plugins: ['advlist', 'autolink', 'lists', 'link', 'image', 'charmap',
        'preview', 'anchor', 'searchreplace', 'visualblocks', 'fullscreen',
        'insertdatetime', 'table', 'help', 'wordcount'],
      // 工具栏按钮
      toolbar: `undo redo | formatpainter casechange blocks | bold italic backcolor | 
        alignleft aligncenter alignright alignjustify | bullist numlist checklist outdent indent | 
        removeformat | a11ycheck code table help`,
      branding: false, // 隐藏Logo
      language: 'zh_CN', // 中文菜单
      // toolbar_mode: 'floating', // 工具栏模式
      // tinycomments_mode: 'embedded', // 模式
      // width: 800, // 宽度高度，可以设置最大、最小宽高
      // height: 400,
      // menubar: false, // 隐藏菜单栏
      setup: function (editor) {
        editor.on('input change undo redo execCommand KeyUp', function () {
          component.flag = false;
          component.$emit('input', editor.getContent());
        })
      },
    });
  },
}

