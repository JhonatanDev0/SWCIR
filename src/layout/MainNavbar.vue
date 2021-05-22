<template>
  <navbar
    position="fixed"
    type="default"
    :transparent="transparent"
    :color-on-scroll="colorOnScroll"
    menu-classes="ml-auto"
  >
    <template>
      <router-link v-popover:popover1 style="text-shadow: 2px 2px black;" class="navbar-brand" to="/">
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
    <template slot="navbar-menu">
      <drop-down
              tag="li"
              title="Acessar Conta"
              icon="now-ui-icons gestures_tap-01"
              class="nav-item"
      >
        <nav-link to="/login">
          <i class="now-ui-icons users_single-02"></i> Login
        </nav-link>
        <nav-link to="/Signup">
          <i class="now-ui-icons ui-1_simple-add"></i> Cadastro
        </nav-link>
      </drop-down>
    </template>
  </navbar>
</template>

<script>
import { DropDown, Navbar, NavLink } from '@/components';
import { Popover } from 'element-ui';
export default {
  name: 'main-navbar',
  props: {
    transparent: Boolean,
    colorOnScroll: Number
  },
  components: {
    DropDown,
    Navbar,
    NavLink,
    [Popover.name]: Popover
  }
};
</script>

<style scoped></style>
