<template>
  <div>

    <div style="font-size:30px;text-align: center;padding: 30px 0">
      <el-icon size="25px">
        <timer/>
      </el-icon>
      管理进程时间
    </div>
  </div>
  <div style="margin-left: 10px">
    <el-row :gutter="20">
      <el-col span="4">
        <div class="block">
          <span class="demonstration">申报开始：</span>
          <el-date-picker
              v-model="Data.appStartDate"
              type="date"
              placeholder="选择日期">
          </el-date-picker>
        </div>
      </el-col>
      <el-col span="4">
        <div class="block">
          <span class="demonstration">申报结束：</span>
          <el-date-picker
              v-model="Data.appEndDate"
              type="date"
              placeholder="选择日期">
          </el-date-picker>
        </div>
      </el-col>
      <el-col span="4">
        <div class="block">
          <span class="demonstration">审批开始：</span>
          <el-date-picker
              v-model="Data.checkStartDate"
              type="date"
              placeholder="选择日期">
          </el-date-picker>
        </div>
      </el-col>
      <el-col span="4">
        <div class="block">
          <span class="demonstration">审批结束：</span>
          <el-date-picker
              v-model="Data.checkEndDate"
              type="date"
              placeholder="选择日期">
          </el-date-picker>
        </div>
      </el-col>
    </el-row>
  </div>
  <div style="margin-left: 90%;margin-top: 50px">
    <el-button type="primary" @click="setDate">确定</el-button>
  </div>
</template>

<script>
import request from "@/utils/requset";

export default {
  name: "ManageView",
  data() {
    return {
      Data:{},

    };
  },
  methods:{
    setDate(){
      request.post("/setDate",this.Data).then(res=>{
        if(res.code=='0'){
          this.$message({
            type:"success",
            message:"设置成功"
          })
        }
        else{
          this.$message({
            type:"error",
            message:res.msg
          })
        }
      })
    }
  }

}
</script>

<style scoped>

</style>