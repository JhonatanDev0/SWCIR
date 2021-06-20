<template>
  <div>
    <div class="page-header clear-filter" filter-color="none">
      <parallax
        class="page-header-image"
        style="background-image: url('img/bg5.jpg')"
      >
      </parallax>
      <div class="container">
        <div class="photo-container">
          <img
            src="img/jhonatan.jpg"
            alt="imagem do usuário"
            style="max-width: 100%"
          />
        </div>
        <h3 class="title">Jhonatan</h3>
        <p class="category">Estudante de TI</p>
        <!-- <div class="content">
          <div class="social-description">
            <h2>X</h2>
            <p>Bens</p>
          </div>
          <div class="social-description">
            <h2>X</h2>
            <p>Rendimentos</p>
          </div>
          <div class="social-description">
            <h2>X</h2>
            <p>Pagamentos</p>
          </div>
          <div class="social-description">
            <h2>X</h2>
            <p>Favorecidos</p>
          </div>
          <div class="social-description">
            <h2>X</h2>
            <p>Contribuinte</p>
          </div>
          <div class="social-description">
            <h2>X</h2>
            <p>Dependentes</p>
          </div>
        </div> -->
      </div>
    </div>
    <div>
      <h4 class="title text-center">Alíquota 2021</h4>
      <p style="width: 50% !important; margin: auto">
        <b
          >A alíquota é usada para calcular o valor final que uma pessoa ou
          empresa pagará de imposto.</b
        >
      </p>
      <table
        class="styled-table"
        border="3"
        style="width: 50% !important; margin: auto"
      >
        <thead>
          <tr>
            <td><b>BASE DE CÁLCULO (R$)</b></td>
            <td><b>ALÍQUOTA (%)</b></td>
            <td><b>PARCELA A DEDUZIR DO IRPF</b></td>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Até 1.903,98</td>
            <td>isento</td>
            <td>isento</td>
          </tr>
          <tr>
            <td>De 1.903,99 até 2.826,65</td>
            <td>7,5%</td>
            <td>R$142,80</td>
          </tr>
          <tr>
            <td>De 2.826,66 até 3.751,05</td>
            <td>15%</td>
            <td>R$354,80</td>
          </tr>
          <tr>
            <td>De 3.751,06 até 4.664,68</td>
            <td>22,5%</td>
            <td>R$636,13</td>
          </tr>
          <tr>
            <td>Acima de 4.664,68</td>
            <td>27,5%</td>
            <td>R$869,36</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div>
      <h4 class="title text-center">Meus Dados</h4>
    </div>
    <div class="a-box">
      <div class="text-container">
        <h3>Contribuinte 1</h3>
        <div class="textp">
          <p><b>Id:</b> {{ id }}</p>
          <p><b>Nome:</b> {{ nome }}</p>
          <p><b>Email: </b>{{ email }}</p>
          <p><b>Cpf:</b> {{ cpf }}</p>
          <p><b>Data:</b> {{ data }}</p>
          <p><b>Ocupação:</b> {{ ocupacao }}</p>
          <p><b>Número Pis/Pasep:</b> {{ pispasep }}</p>
          <p><b>Número Dependentes:</b> {{ numDep }}</p>
          <p><b>Número Recibo Anterior:</b> {{ numRecibo }}</p>
          <p><b>Natureza Ocupação:</b> {{ natOcup }}</p>
          <p><b>Título Eleitoral:</b> {{ tituEleitoral }}</p>
        </div>
        <n-button
          class="btn"
          style="color: white; background-color: red"
          v-on:click="excluirDado"
          ><i class="now-ui-icons ui-1_simple-remove"></i
        ></n-button>
        <!--<n-button class="btn" style="color: white; background-color: green"
          ><i class="now-ui-icons design-2_ruler-pencil"></i
        ></n-button> -->
      </div>
    </div>
    <!-- <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-6 ml-auto mr-auto">
            <h4 class="title text-center">Minhas Imagens</h4>
          </div>
          <tabs
            pills
            class="nav-align-center"
            tab-content-classes="gallery"
            tab-nav-classes="nav-pills-just-icons"
            type="info"
          >
            <tab-pane title="Profile">
              <i slot="label" class="now-ui-icons health_ambulance"></i>

              <div class="col-md-10 ml-auto mr-auto">
                <div class="row collections">
                  <div class="col-md-6">
                    <img
                      src="img/medico1.png"
                      class="img-raised"
                      style="max-width: 100%"
                    />
                    <img
                      src="img/medico2.png"
                      alt=""
                      class="img-raised"
                      style="max-width: 100%"
                    />
                  </div>
                  <div class="col-md-6">
                    <img
                      src="img/medico3.jpg"
                      alt=""
                      class="img-raised"
                      style="max-width: 100%"
                    />
                    <img
                      src="img/medico4.png"
                      alt=""
                      class="img-raised"
                      style="max-width: 100%"
                    />
                  </div>
                </div>
              </div>
            </tab-pane>

            <tab-pane title="Home">
              <i slot="label" class="now-ui-icons education_hat"></i>

              <div class="col-md-10 ml-auto mr-auto">
                <div class="row collections">
                  <div class="col-md-6">
                    <img
                      src="img/educacao1.png"
                      alt=""
                      class="img-raised"
                      style="max-width: 100%"
                    />
                    <img
                      src="img/educacao2.png"
                      alt=""
                      class="img-raised"
                      style="max-width: 100%"
                    />
                  </div>
                  <div class="col-md-6">
                    <img
                      src="img/educacao3.jpg"
                      alt=""
                      class="img-raised"
                      style="max-width: 100%"
                    />
                    <img
                      src="img/educacao4.jpg"
                      alt=""
                      class="img-raised"
                      style="max-width: 100%"
                    />
                  </div>
                </div>
              </div>
            </tab-pane>

            <tab-pane title="Messages">
              <i slot="label" class="now-ui-icons objects_support-17"></i>

              <div class="col-md-10 ml-auto mr-auto">
                <div class="row collections">
                  <div class="col-md-6">
                    <img
                      src="img/doacao1.png"
                      alt=""
                      class="img-raised"
                      style="max-width: 100%"
                    />
                    <img
                      src="img/doacao2.jpg"
                      alt=""
                      class="img-raised"
                      style="max-width: 100%"
                    />
                  </div>
                  <div class="col-md-6">
                    <img
                      src="img/doacao3.png"
                      alt=""
                      class="img-raised"
                      style="max-width: 100%"
                    />
                    <img
                      src="img/doacao4.gif"
                      class="img-raised"
                      style="max-width: 100%"
                    />
                  </div>
                </div>
              </div>
            </tab-pane>
          </tabs>
        </div>
      </div>
    </div> -->

    <br />
  </div>
</template>
<script>
/* import { Tabs, TabPane } from "@/components"; */
import { Button } from "@/components";
import userServicesCont from "../services/users";
export default {
  name: "profile",
  bodyClass: "profile-page",
  components: {
    [Button.name]: Button,
    /*Tabs,
    TabPane, */
  },
  data() {
    return {
      nome: "",
      email: "",
      id: "",
      cpf: "",
      data: "",
      ocupacao: "",
      pispasep: "",
      numDep: "",
      numRecibo: "",
      tituEleitoral: "",
      natOcup: "",
    };
  },
  beforeMount() {
    this.mostrarDadoCont();
  },
  methods: {
    mostrarDadoCont() {
      //userServicesCont.puxarDadoContribuinte().then(r => console.log(r.data)).catch(error => console.log(error.message))
      userServicesCont.puxarDadoContribuinte().then((r) => {
        const dados = r.data;
        this.id = dados[0].userId;
        this.nome = dados[0].name;
        this.email = dados[0].email;
        this.cpf = dados[0].cpf;
        this.data = dados[0].dataNasc;
        this.ocupacao = dados[0].ocupacao;
        this.pispasep = dados[0].nitPisPasep;
        this.numDep = dados[0].numDependentes;
        this.numRecibo = dados[0].numReciboAnterior;
        this.tituEleitoral = dados[0].tituloEleitoral;
        this.natOcup = dados[0].natOcupacao;
        console.log(dados);
      });
    },
    excluirDado() {
      userServicesCont
        .excluirDadoContribuinte(this.id)
        .then((r) => {
          window.alert("Usuário Excluído");
        })
        .catch((error) => console.log(error.message));
    },
  },
};
</script>
<style>
.styled-table {
  border-collapse: collapse;
  margin: 25px 0;
  font-size: 0.9em;
  font-family: sans-serif;
  min-width: 400px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

.styled-table thead tr {
  background-color: #2ca8ff;
  color: #ffffff;
  text-align: left;
}

.styled-table th,
.styled-table td {
  padding: 12px 15px;
}

.styled-table tbody tr.active-row {
  font-weight: bold;
  color: #009879;
}

.a-box {
  display: inline-block;
  width: 240px;
  text-align: center;
}
.text-container {
  box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.2);
  padding: 5px 20px 20px 20px;
  border-radius: 20px;
  background: #fff;
  position: relative;
  left: 825px;
  line-height: 19px;
  font-size: 14px;
}
.textp {
  text-align: left;
}
.text-container h3 {
  margin: 20px 0px 10px 0px;
  color: #000000;
  font-size: 18px;
  font-weight: bold;
}
.buttonedit {
  border-radius: 100px;
}
</style>
