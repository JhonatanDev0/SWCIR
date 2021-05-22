<template>
  <div class="page-header clear-filter" filter-color="none">
    <div
      class="page-header-image"
      style="background-image: url('img/login.jpg')"  
    ></div>
    <div class="content">
      <div class="container">
        <div class="col-md-5 ml-auto mr-auto">
          <card type="login" plain>
            <div slot="header" class="logo-container">
              <img v-lazy="'img/now-logo.png'" alt="logo do site" style="max-width: 100%"/>
            </div>

            <fg-input
              class="no-border input-lg"
              addon-left-icon="now-ui-icons users_circle-08"
              placeholder="Username..."
            >
            </fg-input>

            <fg-input
              class="no-border input-lg"
              addon-left-icon="now-ui-icons ui-1_lock-circle-open"
              placeholder="Senha..."
            >
            </fg-input>

            <template slot="raw-content">
              <div class="card-footer text-center">
                <a
                  href="#/profile"
                  class="btn btn-info btn-round btn-lg btn-block"
                  style="text-shadow: 2px 2px black"
                  >Começar</a
                >
              </div>
              <div class="pull-left">
                <h6>
                  <a style="text-shadow: 2px 2px black">Não possui conta?</a>
                </h6>
              </div>
              <div class="pull-right">
                <h6>
                  <a href="#/Signup" class="link footer-link" style="text-shadow: 2px 2px black">Criar Conta</a>
                </h6>
              </div>
            </template>
          </card>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { Card, Button, FormGroupInput } from '@/components';
export default {
  name: 'login-page',
  bodyClass: 'login-page',
  components: {
    Card,
    [Button.name]: Button,
    [FormGroupInput.name]: FormGroupInput
  }
};
</script>
<style></style>
