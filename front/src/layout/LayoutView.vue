<template>
<div>
  <Header />
  <div style="display:flex">

    <!--    <router-link to="/statistics">Go to </router-link>-->
    <div style="width: 100%"> <router-view /></div>
  </div>

</div>
</template>

<script>
import Header from "@/components/Header";


export default {
  name: "LayoutView",
  components: {
    Header,
  },
}
</script>

<style scoped>

</style>