<template>
<div>
  <Header />
  <div style="display:flex">
    <Aside />
    <!--    <router-link to="/statistics">Go to </router-link>-->
    <div style="width: 100%"> <router-view /></div>
  </div>

</div>
</template>

<script>
import Header from "@/components/Header";
import Aside from "@/components/Aside";

export default {
  name: "LayoutView",
  components: {
    Header,
    Aside
  },
}
</script>

<style scoped>

</style>