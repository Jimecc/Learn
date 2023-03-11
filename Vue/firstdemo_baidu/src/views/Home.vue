<template>

  <div>
    <div class="divPopover">

    </div>
    <div  style="margin-top: 12%">
      <img src="../assets/logo.png" style="width: 240px" @click="doOpenBlog">
    </div>
    <div style="margin-top:10px">
      <el-input v-model="searchInput" @keydown.enter.native="doSearch" placeholder="请输入搜索内容..."></el-input>
      <el-button type="primary" class="buttonSearch" @click="doSearch">百度一下 </el-button>
    </div>
    <div style="margin-top: 45px">
<!--      style="background-image:url(https://files.catbox.moe/rn2kav.gif)"-->
      <el-button class="buttonSeniorSearch" type="primary" style="background-image:url(https://files.catbox.moe/nkmcwl.gif)" @click="showSeniorSearch" size="mini" icon="el-icon-search">高级搜索</el-button>
<!--      <el-button class="buttonSeniorSearch" type="primary" size="mini" icon="el-icon-setting">搜索设置</el-button>-->
    </div>

    <el-dialog
        title="高级搜索"
        :visible.sync="dialogVisible"
        width="60%">
      <h3 style="text-align: left;margin-left: 5%;margin-bottom: 10px">搜索结果：</h3>
      <el-row style="margin-top: 10px">
        <el-col :span="12">
          <div>
            <el-input style="width: 80%" v-model="seniorSearch.q1" size="small" placeholder="请输入内容">
              <template slot="prepend">包含全部关键词</template>
            </el-input>
          </div>
        </el-col>
        <el-col :span="12">
          <div>
            <el-input style="width: 80%" v-model="seniorSearch.q2" size="small" placeholder="请输入内容">
              <template slot="prepend">包含完整关键词</template>
            </el-input>
          </div>
        </el-col>
      </el-row>
      <el-row style="margin-top: 10px">
        <el-col :span="12">
          <div>
            <el-input style="width: 80%" v-model="seniorSearch.q3" size="small" placeholder="请输入内容">
              <template slot="prepend">包含任意关键词</template>
            </el-input>
          </div>
        </el-col>
        <el-col :span="12">
          <div>
            <el-input style="width: 80%" size="small" v-model="seniorSearch.q4" placeholder="请输入内容">
              <template slot="prepend">不包含关键词&emsp;</template>
            </el-input>
          </div>
        </el-col>
      </el-row>

      <!--      <div style="width: 70%;margin-left: 15%">-->
      <!--        <el-divider ></el-divider>-->
      <!--      </div>-->

      <el-row style="margin-top: 10px">
        <el-col :span="12">
          <div style="display: flex">
            <span style="font-size:14px;margin-left: 50px;margin-top: 5px"><b>时间：</b>限定要搜索的网页时间是</span>
          </div>
        </el-col>

        <el-col :span="12">
          <div style="text-align: left;margin-left: 10%">
            <el-select style="width: 70%" size="small" v-model="getTimeS">
              <el-option
                  v-for="item in selectTime"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </div>
        </el-col>

      </el-row>

      <el-row style="margin-top: 10px">
        <el-col :span="12">
          <div style="display: flex">
            <span style="font-size:14px;margin-left: 50px;margin-top: 5px"><b>文档格式：</b>搜索网页格式是</span>
          </div>
        </el-col>

        <el-col :span="12">
          <div style="text-align: left;margin-left: 10%">
            <el-select style="width: 70%" size="small" v-model="seniorSearch.ft">
              <el-option
                  v-for="item in fileFormats"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </div>
        </el-col>

      </el-row>

      <!--      <div style="width: 70%;margin-left: 15%">-->
      <!--        <el-divider ></el-divider>-->
      <!--      </div>-->

      <el-row style="margin-top: 10px">
        <el-col :span="12">
          <div style="display: flex">
            <span style="font-size:14px;margin-left: 50px;margin-top: 5px"><b>关键词位置：</b>查询的关键词位于</span>
          </div>
        </el-col>

        <el-col :span="12">
          <div style="text-align: left;margin-left: 10%">
            <template>
              <el-radio-group v-model="seniorSearch.q5">
                <el-radio :label="null">网页任何地方</el-radio>
                <el-radio :label="1">仅网页标题中</el-radio>
                <el-radio :label="2">仅 URL 中</el-radio>
              </el-radio-group>
            </template>
          </div>
        </el-col>
      </el-row>

      <el-row style="margin-top: 10px">
        <el-col :span="12">
          <div style="display: flex">
            <span style="font-size:14px;margin-left: 50px;margin-top: 5px"><b>站内搜索：</b>限定要搜索指定的网站是</span>
          </div>
        </el-col>
        <el-col :span="12">
          <div>
            <el-input style="width: 60%" size="small" placeholder="请输入内容" v-model="seniorSearch.q6">
              <template slot="prepend">网站域名：</template>
            </el-input>
            如：baidu.com
          </div>
        </el-col>
      </el-row>



      <span slot="footer" class="dialog-footer">
    <el-button type="primary" @click="doSeniorSearch">高级搜索</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "home",
  data(){
    return{
      getTimeS:0,
      befTime:'',
      searchInput:'' ,
      date:null,
      dialogVisible: false,
      place:null,
      seniorSearch:{
        q1:'',
        q2:'',
        q3:'',
        q4:'',
        q5:null,
        q6:'',
        ft:''
      },
      fileFormats:[
        {
          value:'',
          label:'所有网页和文件'
        },
        {
          value:'pdf',
          label:'Adobe Acrobat PDF (.pdf)'
        },
        {
          value:'doc',
          label:'微软 Word (.doc)'
        },
        {
          value:'xls',
          label:'微软 Excel (.xls)'
        },
        {
          value:'ppt',
          label:'微软 Powerpoint (.ppt)'
        },
        {
          value:'rtf',
          label:'RTF 文件 （.rtf)'
        },
        {
          value:'all',
          label:'所有格式'
        }
      ],
      selectTime:[
        {
          value:0,
          label:'所有时间'
        },
        {
          value:1,
          label:'最近一天'
        },
        {
          value:2,
          label:'最近一周'
        },
        {
          value:3,
          label:'最近一月'
        },
        {
          value:4,
          label:'最近一年'
        }
      ]
    }
  },
  mounted() {
    console.log("%c欢迎使用纯净版 Baidu，我们只为追求极简。\nGithub:https://github.com/Jimecc","color:pink");
  },
  methods:{
    getTimeStamp(a) {
      let time = new Date().getTime();
      let now = (time + '').substring(0, 10);
      let befTime = '';
      if(a == 0){
        return 'gpc=stf';
      }
      if(a == 1){
        befTime = ((time - 1000 * 60 * 60 * 24) + '').substring(0, 10);
        return 'gpc=stf%3D'+befTime+'.906%2C'+now+'.906%7Cstftype%3D1';
      }
      if(a == 2){
        befTime = ((time - 7 * 1000 * 60 * 60 * 24) + '').substring(0, 10);
        return 'gpc=stf%3D'+befTime+'.906%2C'+now+'.906%7Cstftype%3D1';
      }
      if(a == 3){
        let curretMonth = (new Date((new Date()).getFullYear(), (new Date()).getMonth() + 1, 0)).getDate();
        befTime = ((time - curretMonth * 1000 * 60 * 60 * 24) + '').substring(0, 10);
        return 'gpc=stf%3D'+befTime+'.906%2C'+now+'.906%7Cstftype%3D1';
      }
      if(a == 4){
        befTime = ((time - 365 * 1000 * 60 * 60 * 24) + '').substring(0, 10);
        return 'gpc=stf%3D'+befTime+'.906%2C'+now+'.906%7Cstftype%3D1';
      }

    },
    doSeniorSearch(){
      let timeStamp = 'gpc=stf';
      timeStamp = this.getTimeStamp(this.getTimeS);
      window.open('https://www.baidu.com/s?q1='+this.seniorSearch.q1+'&q2='+this.seniorSearch.q2+'&q3='+this.seniorSearch.q3+'&q4='+this.seniorSearch.q4+'&'+timeStamp+'&ft='+this.seniorSearch.ft+'&q5='+this.seniorSearch.q5+'&q6='+this.seniorSearch.q6+'&tn=baiduadv');
    },
    showSeniorSearch(){
      this.dialogVisible = true;
    },
    doSearch(){
      if(this.searchInput != null && this.searchInput != ''){
        window.open('https://www.baidu.com/s?wd='+this.searchInput,'_self');
      }
    },
    doOpenBlog(){
      window.open('http://jime.cc/','_self');
    }
  }
}
</script>

<style scoped>
.divClass{
  display: flex;
}
.el-input{
  width:40%;
  border-radius: 10px 0 0 10px;

}

.buttonSearch {
  background: #4e6ef2;
  border-radius: 0 12px 12px 0;
}
.buttonSeniorSearch{
  background: #4e6ef2;
  border-radius: 15px;
}


.imgAvatar{
  width: 30px;
  border: 2px solid #4e6ef2;
  box-sizing: content-box;
  border-radius: 30px;
  /*filter: blur(5px);*/
}

.elDialog{
  width: 1700px;
  height: 500px;
  /*border: 2px solid #4e6ef2;*/
  border-radius: 390px;
}

.divPopover{
  text-align: right;
  margin-right: 60px;
}

.elInput{
  border-radius: 20px;
}
</style>
