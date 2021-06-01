<template>
  <div>
    <div class="page-header clear-filter" filter-color="blue">
      <parallax
        class="page-header-image"
        style="background-image: url('img/header.jpg')"
      >
      </parallax>
      <div class="container">
        <div class="content-center brand">
          <img class="n-logo" src="img/now-logo.png" alt="logo do site" />
          <h1 class="h1-seo" style="text-shadow: 2px 2px black">SWCIR</h1>
          <h3 style="text-shadow: 2px 2px black">
            Feito para você que se perde com documentos.
          </h3>
            <div v-if="!$auth.loading">
              <!-- show login when not authenticated -->
              <n-button type="neutral" round style="color: black" v-if="!$auth.isAuthenticated" @click="login">
                <i class="now-ui-icons ui-1_send"></i> Comece já
              </n-button>
              <!-- show logout when authenticated -->
              <n-button type="neutral" round style="color: black" v-if="$auth.isAuthenticated" @click="logout">
                <i class="now-ui-icons ui-1_send"></i> Log out
              </n-button>
            </div>
        </div>
        <h6 class="category category-absolute">
          Designed by
          <a href="http://invisionapp.com/" target="_blank">
            <img src="img/invision-white-slim.png" class="invision-logo" /> </a
          >. Coded by
          <a href="https://github.com/JhonatanDev0" target="_blank">
            <img
              src="img/creative-tim-white-slim2.png"
              class="creative-tim-logo"
            />
          </a>
        </h6>
      </div>
    </div>
    <div class="main">
      <div class="section">
        <div class="container text-center">
          <div class="row justify-content-md-center">
            <div class="col-md-12 col-lg-8">
              <h2 class="title">Sobre o projeto</h2>
              <h5>
                O SWCIR propõe a facilidade de organizar informações de
                documentos para declaração de imposto de renda de pessoa física,
                propondo assim a diminuição e complicação em ter que guardar
                inúmeros documentos para que se possa fazer a declaração. Além
                da facilidade em armazenar é possível que o usuário deste
                sistema gerencie suas informações e possa enviá-lo para o
                contador.
              </h5>
              <h2 class="title">Desenvolvedores</h2>
              <div id="images">
                <a href="https://github.com/Haruwa" target="_blank">
                  <img
                    v-lazy="'img/jaime.jpg'"
                    alt="Thumbnail Image"
                    class="rounded-circle img-raised pull-left"
                  />
                </a>
                <a href="https://github.com/JhonatanDev0" target="_blank">
                  <img
                    v-lazy="'img/jhonatan.jpg'"
                    alt="Thumbnail Image"
                    class="rounded-circle img-raised pull-right"
                  />
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { Parallax } from "@/components";
import { Button } from "@/components";
export default {
  name: "index",
  bodyClass: "index-page",
  components: {
    Parallax,
    [Button.name]: Button,
  },
  methods: {
    // Log the user in
    login() {
      this.$auth.loginWithRedirect();
    },
    // Log the user out
    logout() {
      this.$auth.logout({
        returnTo: window.location.origin
      });
    }
  }
};
</script>
<style></style>
