<template>
  <div style="width: 900px;margin-right: auto;margin-left: auto">
    <div style="font-size:30px;text-align: center;padding: 30px 0">
      {{ Application.title }}
    </div>
    <div style="text-align: center;padding: 30px 0;">
      时间：{{ Application.appTime }}
    </div>
    <div>
      <el-card>
        <div slot="header" class="clearfix">
          <span>描述</span>
        </div>
        <el-divider></el-divider>
        <div class="text item">
          <v-md-preview :text="Application.description"
                        style="margin-left: auto;margin-right: auto;width: 80%;"></v-md-preview>
        </div>
      </el-card>
    </div>
    <div>
      <a :href="Application.file" style="margin-top:20px;margin-left: 30px">附件</a>
    </div>
    <div v-if="role==1&&Application.state==0" style="float: right">
      <el-button type="success" @click="check(2)">
        通过
      </el-button>
      <el-button type="danger" style="margin-left: 30px" @click="check(1)">
        不通过
      </el-button>
    </div>
  </div>
</template>

<script>
import request from "@/utils/requset";

export default {
  name: "ApplicationDetailsView",
  created() {

    request.get("/getApplicationById", {
      params: {
        id: this.$route.query.appid
      }
    }).then(res => {
      console.log(res)
      this.Application = res.data

    })
    this.role = JSON.parse(sessionStorage.getItem("role"));
  },
  data() {
    return {
      role: '',
      Application: {},
    }
  },
  methods: {
    check(state) {
      request.get("/checkApplication",{
        params:{
          id:this.Application.id,
          state:state,
        }
      }).then(res=>{
        this.$message({
          type:"success",
          message:"操作成功"
        })
        this.$router.push("/check")
      })
    }
  }
}
</script>

<style scoped>

</style>