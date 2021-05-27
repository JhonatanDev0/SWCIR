<template>
  <div class="page-header clear-filter" filter-color="none">
    <div
      class="page-header-image"
      style="background-image: url('img/login.jpg')"
    ></div>
    <div class="content" method="POST">
      <div class="container">
        <div class="col-md-5 ml-auto mr-auto">
          <card type="login" plain name="login">
            <div slot="header" class="logo-container">
              <img
                v-lazy="'img/now-logo.png'"
                alt="logo do site"
                style="max-width: 100%"
              />
            </div>

            <fg-input
              class="no-border input-lg"
              addon-left-icon="now-ui-icons users_circle-08"
              placeholder="Nome..."
              type="text"
              aria-required="true"
              v-model="name"
            >
            </fg-input>

            <fg-input
              class="no-border input-lg"
              addon-left-icon="now-ui-icons ui-1_email-85"
              placeholder="E-mail..."
              aria-required="true"
              type="email"
              v-model="email"
            >
            </fg-input>

            <fg-input
              class="no-border input-lg"
              addon-left-icon="now-ui-icons ui-1_lock-circle-open"
              placeholder="Senha..."
              aria-required="true"
              type="password"
              id="senha"
              v-model="password"
            >
            </fg-input>
            <input type="checkbox" v-on:click="mostrarOcultarSenha" /> Mostrar
            Senha

            <template slot="raw-content">
              <div class="card-footer text-center">
                <a
                  href="#/profile"
                  class="btn btn-info btn-round btn-lg btn-block"
                  style="text-shadow: 2px 2px black"
                  v-on:click="enviarDados"
                  >Enviar</a
                >
              </div>
              <div class="pull-left">
                <h6>
                  <a style="text-shadow: 2px 2px black">Já possui conta?</a>
                </h6>
              </div>
              <div class="pull-right">
                <h6>
                  <a
                    href="#/login"
                    class="link footer-link"
                    style="text-shadow: 2px 2px black"
                    >Entrar</a
                  >
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
import { Card, FormGroupInput } from "@/components";
import userServices from "../services/users";
import Button from "../components/Button.vue";
import { Input } from 'element-ui';
export default {
  name: "login-page",
  bodyClass: "login-page",
  components: {
    Card,
    //Button,
    //[Button.name]: Button,
    [FormGroupInput.name]: FormGroupInput,
  },
  data() {
    return {
      name: "",
      email: "",
      password: "",
    };
  },
  methods: {
    enviarDados(e) {
      e.preventDefault();
      console.log(e);
      const body = {
        name: this.name,
        email: this.email,
        password: this.password,
      };
      userServices
        .cadastrarUsuario(body)
        .then((r) => {
          alert("Dados enviados");
          window.location.href = "http://localhost:8080/#/login";
        })
        .catch((r) => alert.error("Dados não enviados"));
    },
    mostrarOcultarSenha() {
      var senha = document.getElementById("senha");
      if (senha.type == "password") {
        senha.type = "text";
      } else {
        senha.type = "password";
      }
    },
    validar() {
      var name = login.name.value;
      var email = login.email.value;
      var password = login.password.value;

      if (nome == "") {
        alert("Preencha o campo nome. ");
        login.name.focus();
        return false;
      }
      if (password == "" || password.length <= 5) {
        alert("Preencha o campo nome. ");
        login.password.focus();
        return false;
      }
      if (email == "" || email.indexOf("@") == -1) {
        alert("Preencha o campo nome. ");
        login.email.focus();
        return false;
      }
    },
  },
};
</script>
<style></style>
