export default {
  template: `<div>
              <table id="list">
                <tr>
                  <td>글제목</td>
                  <td><input type="text" style="width:90%; " v-model="title"></td>
                </tr>
                <tr>
                  <td colspan="2">
                  <textarea style="width:100%;" v-model="content"></textarea>
                  </td>
                </tr>     
              </table>
              <router-link 
                  tag="button" 
                  style="float:right;" 
                  v-bind:to="{name:'boardList'}">
                  목록</router-link>
              <button style="float:right;" v-on:click="boardSave">저장</button>
            </div>`,
  data: function () {
    return {
      title: "",
      content: "",
      object: [],
    };
  },
  created: function () {
    this.object = this.$parent.getParentData();
  },
  methods: {
    boardSave: function () {
      // 게시글 저장
      // 다른 방식
      // let dataList = this.$parent.getParentData();

      // if (dataList.length != 0) {
      //   let index = dataList.length - 1;
      //   no = parseInt(dataList[index].no) + 1;
      // }

      // DataList.push(boardInfo);
      // this. $parent.setParentData(DataList);

      // this.$router.push({ name: "boardList" });

      let no = 1;
      if (this.object.length != 0) {
        let index = this.object.length - 1;
        no = parseInt(this.object[index].no) + 1;
      }

      let boardInfo = {
        no: no,
        title: this.title,
        content: this.content,
        view: "1",
      };

      this.object.push(boardInfo);
      this.$parent.setParentData(this.object);
      this.$router.push({ name: "boardList" });
    },
  },
};
