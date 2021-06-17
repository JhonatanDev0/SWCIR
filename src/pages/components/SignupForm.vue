<template>
  <div
    class="section section-signup"
    style="
      background-size: cover;
      background-position: top center;
      min-height: 700px;
    "
  >
    <div class="container">
      <div class="row pull-left">
        <card class="card-signup" header-classes="text-center" color="black">
          <template slot="header">
            <h3 class="card-title title-up">Cadastro Contribuinte</h3>
          </template>
          <template>
            <fg-input
              class="no-border"
              placeholder="Nome Completo..."
              addon-left-icon="now-ui-icons users_circle-08"
              v-model="name"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="E-mail..."
              addon-left-icon="now-ui-icons users_circle-08"
              v-model="email"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Ocupação..."
              addon-left-icon="now-ui-icons text_caps-small"
              v-model="ocupacao"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="CPF..."
              addon-left-icon="now-ui-icons business_badge"
              v-model="cpf"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Data de Nascimento..."
              addon-left-icon="now-ui-icons ui-1_calendar-60"
              type="date_time"
              v-model="dataNasc"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Número Pis/Pasep..."
              addon-left-icon="now-ui-icons design_bullet-list-67"
              v-model="nitPisPasep"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Titulo Eleitoral..."
              addon-left-icon="now-ui-icons business_badge"
              v-model="tituloEleitoral"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="numDependentes..."
              addon-left-icon="now-ui-icons users_circle-08"
              v-model="numDependentes"
            >
            </fg-input>

          </template>
          <div class="card-footer text-center">
            <n-button type="neutral" round size="lg" style="color: black" v-on:click="enviarDadosCont"
              >Cadastrar</n-button
            >
          </div>
        </card>
      </div>
      <div class="col text-center"></div>
    </div>

    <div class="container">
      <div class="row pull-right">
        <card class="card-signup" header-classes="text-center" color="black">
          <template slot="header">
            <h3 class="card-title title-up">Cadastro Rendimentos</h3>
          </template>
          <template>
            <fg-input
              class="no-border"
              placeholder="Fonte do Pagamento..."
              addon-left-icon="now-ui-icons text_caps-small"
              v-model="tipoFontPag"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Documento Fonte do Pagamento..."
              addon-left-icon="now-ui-icons ui-1_email-85"
              v-model="docFontPag"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Nome da Fonte do Pagemento..."
              addon-left-icon="now-ui-icons text_caps-small"
              v-model="nomeFontPag"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Valor da Renda..."
              addon-left-icon="now-ui-icons business_money-coins"
              v-model="valorRend"
            >
            </fg-input>
          </template>
          <div class="card-footer text-center">
            <n-button type="neutral" round size="lg" style="color: black" v-on:click="enviarDadosRend"
              >Cadastrar</n-button
            >
          </div>
        </card>
      </div>
      <div class="col text-center"></div>
    </div>

    <div class="container">
      <div class="row">
        <card class="card-signup" header-classes="text-center" color="black">
          <template slot="header">
            <h3 class="card-title title-up">Cadastro Bens</h3>
          </template>
          <template>
            <fg-input
              class="no-border"
              placeholder="Documento Referente..."
              addon-left-icon="now-ui-icons ui-1_email-85"
              v-model="docRef"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Valor dois anos..."
              addon-left-icon="now-ui-icons business_money-coins"
              v-model="valorDoisAnos"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Valor ano anterior..."
              addon-left-icon="now-ui-icons business_money-coins"
              v-model="valorAnoAnt"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Discriminação..."
              addon-left-icon="now-ui-icons text_caps-small"
              v-model="discriminacao"
            >
            </fg-input>
          </template>
          <div class="card-footer text-center">
            <n-button type="neutral" round size="lg" style="color: black" v-on:click="enviarDadosBens"
              >Cadastrar</n-button
            >
          </div>
        </card>
      </div>
      <div class="col text-center"></div>
    </div>
<br>
    <div class="containerPag">
      <div class="row pull-left">
        <card class="card-signup" header-classes="text-center" color="black">
          <template slot="header">
            <h3 class="card-title title-up">Cadastro Pagamentos</h3>
          </template>
          <template>
            <fg-input
              class="no-border"
              placeholder="Realizado Com..."
              addon-left-icon="now-ui-icons text_caps-small"
              v-model="realizadoCom"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Valor Pago..."
              addon-left-icon="now-ui-icons business_money-coins"
              v-model="valorPago"
            >
            </fg-input>
          </template>
          <div class="card-footer text-center">
            <n-button type="neutral" round size="lg" style="color: black" v-on:click="enviarDadosPag"
              >Cadastrar</n-button
            >
          </div>
        </card>
      </div>
      <div class="col text-center"></div>
    </div>
<br>
    <div class="container">
      <div class="row pull-right">
        <card class="card-signup" header-classes="text-center" color="black">
          <template slot="header">
            <h3 class="card-title title-up">Cadastro Favorecidos</h3>
          </template>
          <template>
            <fg-input
              class="no-border"
              placeholder="Documento favorecido..."
              addon-left-icon="now-ui-icons business_badge"
              v-model="docFav"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Nome favorecido..."
              addon-left-icon="now-ui-icons text_caps-small"
              v-model="nomeFav"
            >
            </fg-input>
          </template>
          <div class="card-footer text-center">
            <n-button type="neutral" round size="lg" style="color: black" v-on:click="enviarDadosFav"
              >Cadastrar</n-button
            >
          </div>
        </card>
      </div>
    </div>
  </div>
</template>
<script>
import { Card, FormGroupInput, Button } from "@/components";
import userServicesCont from "@/services/users";
import userServicesBens from "@/services/bens";
import userServicesRend from "@/services/rendimentos";
import userServicesFav from "@/services/favorecidos";
import userServicesPag from "@/services/Pagamentos";

export default {
  components: {
    Card,
    [Button.name]: Button,
    [FormGroupInput.name]: FormGroupInput,
  },
  data() {
    return {
      name: "",
      email: "",
      ocupacao: "",
      cpf: "",
      dataNasc: Date,
      nitPisPasep: "",
      tituloEleitoral: "",
      numDependentes: "",
      tipoFontPag: "",
      docFontPag: "",
      nomeFontPag: "",
      valorRend: "",
      docRef: "",
      valorDoisAnos: "",
      valorAnoAnt: "",
      discriminacao: "",
      realizadoCom: "",
      valorPago: "",
      docFav: "",
      nomeFav: "",
    };
  },
  methods: {
    enviarDadosCont(e) {
      e.preventDefault();
      console.log(e);
      const body = {
        name: this.name,
        email: this.email,
        ocupacao: this.ocupacao,
        cpf: this.cpf,
        dataNasc: this.dataNasc,
        nitPisPasep: this.nitPisPasep,
        tituloEleitoral: this.tituloEleitoral,
        numDependentes: this.numDependentes
      };
      userServicesCont
        .cadastrarContribuinte(body)
        .then((r) => {
          alert("Dados enviados");
        })
        .catch((r) => alert.error("Dados não enviados"));

    },
    enviarDadosRend(e) {
      e.preventDefault();
      console.log(e);
      const body = {
        tipoFontPag: this.tipoFontPag,
        docFontPag: this.docFontPag,
        nomeFontPag: this.nomeFontPag,
        valorRend: this.valorRend
      };
      userServicesRend
        .cadastrarRendimentos(body)
        .then((r) => {
          alert("Dados enviados");
        })
        .catch((r) => alert.error("Dados não enviados"));

    },
    enviarDadosBens(e) {
      e.preventDefault();
      console.log(e);
      const body = {
        docRef: this.docRef,
        valorDoisAnos: this.valorDoisAnos,
        valorAnoAnt: this.valorAnoAnt,
        discriminacao: this.discriminacao
      };
      userServicesBens
        .cadastrarBens(body)
        .then((r) => {
          alert("Dados enviados");
        })
        .catch((r) => alert.error("Dados não enviados"));

    },
    enviarDadosPag(e) {
      e.preventDefault();
      console.log(e);
      const body = {
        realizadoCom: this.realizadoCom,
        valorPago: this.valorPago
      };
      userServicesPag
        .cadastrarPagamentos(body)
        .then((r) => {
          alert("Dados enviados");
        })
        .catch((r) => alert.error("Dados não enviados"));

    },
    enviarDadosFav(e) {
      e.preventDefault();
      console.log(e);
      const body = {
        docFav: this.docFav,
        nomeFav: this.nomeFav
      };
      userServicesFav
        .cadastrarFavorecidos(body)
        .then((r) => {
          alert("Dados enviados");
        })
        .catch((r) => alert.error("Dados não enviados"));

    },
  },
};
</script>
<style>
.containerPag{
  right: -75px;
  position: relative;
}
</style>
