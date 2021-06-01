<template>
  <navbar
    position="fixed"
    type="default"
    :transparent="transparent"
    :color-on-scroll="colorOnScroll"
    menu-classes="ml-auto"
  >
    <template>
      <router-link
        v-popover:popover1
        style="text-shadow: 2px 2px black"
        class="navbar-brand"
        to="/"
      >
        SWCIR
      </router-link>
      <el-popover
        ref="popover1"
        popper-class="popover"
        placement="bottom"
        width="200"
        trigger="hover"
      >
        <div class="popover-body">
          Designed by Invision. Coded by JhonatanDev0
        </div>
      </el-popover>
    </template>
  </navbar>
</template>

<script>
import { Popover } from "element-ui";
export default {
  name: "main-navbar",
  props: {
    transparent: Boolean,
    colorOnScroll: Number,
  },
  components: {
    [Popover.name]: Popover,
  },
};
</script>

<style scoped></style>
