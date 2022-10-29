<style scoped>
.router-link-active {
  text-decoration: none;
  color: yellow;
}

a {
  text-decoration: none;
  color: white;
}
</style>

<template>
  <el-menu
      style="min-height:100vh;width: 200px;"
      active-text-color="#ffd04b"
      background-color="#545c64"
      class="el-menu-vertical-demo"
      default-active="statistics"
      text-color="#fff"
      @open="handleOpen"
      @close="handleClose"
      router
  >
    <el-menu-item index="statistics">
      <el-icon>
        <icon-menu/>
      </el-icon>
      <span>
       数据统计
          </span>
    </el-menu-item>
    <el-menu-item index="query">
      <el-icon>
        <icon-menu/>
      </el-icon>
      <span>查询</span>
    </el-menu-item>
    <el-menu-item index="manage">
      <el-icon>
        <icon-menu/>
      </el-icon>
      <span>申报管理</span>
    </el-menu-item>

      <el-menu-item index="notice">
        <el-icon>
          <share/>
        </el-icon>
        <span>通知管理</span>
      </el-menu-item>

    <el-sub-menu index="5">
      <template #title>
        <el-icon>
          <location/>
        </el-icon>
        <span>人员维护</span>
      </template>

        <el-menu-item index="teacher">教师</el-menu-item>

      <el-menu-item index="checker">审批人员</el-menu-item>


    </el-sub-menu>

  </el-menu>
</template>

<script>


export default {
  name: 'Aside',
  components: {}
}
</script>
