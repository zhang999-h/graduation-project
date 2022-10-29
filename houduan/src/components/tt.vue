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
      default-active="1"
      text-color="#fff"

      default-openeds="[1]"

  >

    <el-menu-item index="1">
      <el-icon>
        <icon-menu/>
      </el-icon>
      <span>
       数据统计
          </span>
    </el-menu-item>

    <!--    <router-link to="/query">-->
    <el-menu-item index="query">
      <el-icon>
        <icon-menu/>
      </el-icon>
      <span>查询</span>
    </el-menu-item>
    <!--    </router-link>-->
    <el-menu-item index="3">
      <el-icon>
        <icon-menu/>
      </el-icon>
      <span>申报管理</span>
    </el-menu-item>
    <router-link to="/draft">
      <el-menu-item index="4">
        <el-icon>
          <share/>
        </el-icon>
        <span>拟定申报</span>
      </el-menu-item>
    </router-link>
    <el-sub-menu index="5">
      <template #title>
        <el-icon>
          <location/>
        </el-icon>
        <span>人员维护</span>
      </template>
      <router-link to="/teacher">
        <el-menu-item index="5-1">教师</el-menu-item>
      </router-link>
      <el-menu-item index="5-2">审批人员</el-menu-item>


    </el-sub-menu>
    <el-menu-item index="6">
      <el-icon>
        <icon-menu/>
      </el-icon>
      <span>消息通知</span>
    </el-menu-item>

  </el-menu>
</template>

<script>


export default {
  name: 'Aside',
  components: {}
}
</script>
