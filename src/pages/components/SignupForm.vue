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
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="E-mail..."
              addon-left-icon="now-ui-icons users_circle-08"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="CPF..."
              addon-left-icon="now-ui-icons files_paper"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Data de Nascimento..."
              addon-left-icon="now-ui-icons ui-1_calendar-60"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Número Pis/Pasep..."
              addon-left-icon="now-ui-icons design_bullet-list-67"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Titulo Eleitoral..."
              addon-left-icon="now-ui-icons business_badge"
            >
            </fg-input>
          </template>
          <div class="card-footer text-center">
            <n-button type="neutral" round size="lg" style="color: black"
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
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Documento Fonte do Pagamento..."
              addon-left-icon="now-ui-icons ui-1_email-85"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Nome da Fonte do Pagemento..."
              addon-left-icon="now-ui-icons text_caps-small"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Valor da Renda..."
              addon-left-icon="now-ui-icons business_money-coins"
            >
            </fg-input>
          </template>
          <div class="card-footer text-center">
            <n-button type="neutral" round size="lg" style="color: black"
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
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Valor dois anos..."
              addon-left-icon="now-ui-icons business_money-coins"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Valor ano anterior..."
              addon-left-icon="now-ui-icons business_money-coins"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Discriminação..."
              addon-left-icon="now-ui-icons text_caps-small"
            >
            </fg-input>
          </template>
          <div class="card-footer text-center">
            <n-button type="neutral" round size="lg" style="color: black"
              >Cadastrar</n-button
            >
          </div>
        </card>
      </div>
      <div class="col text-center"></div>
    </div>
<br>
    <div class="container">
      <div class="row">
        <card class="card-signup" header-classes="text-center" color="black">
          <template slot="header">
            <h3 class="card-title title-up">Cadastro Pagamentos</h3>
          </template>
          <template>
            <fg-input
              class="no-border"
              placeholder="Realizado Com..."
              addon-left-icon="now-ui-icons text_caps-small"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Valor Pago..."
              addon-left-icon="now-ui-icons business_money-coins"
            >
            </fg-input>
          </template>
          <div class="card-footer text-center">
            <n-button type="neutral" round size="lg" style="color: black"
              >Cadastrar</n-button
            >
          </div>
        </card>
      </div>
      <div class="col text-center"></div>
    </div>
<br>
    <div class="container">
      <div class="row">
        <card class="card-signup" header-classes="text-center" color="black">
          <template slot="header">
            <h3 class="card-title title-up">Cadastro Favorecidos</h3>
          </template>
          <template>
            <fg-input
              class="no-border"
              placeholder="Documento favorecido..."
              addon-left-icon="now-ui-icons business_badge"
            >
            </fg-input>

            <fg-input
              class="no-border"
              placeholder="Nome favorecido..."
              addon-left-icon="now-ui-icons text_caps-small"
            >
            </fg-input>
          </template>
          <div class="card-footer text-center">
            <n-button type="neutral" round size="lg" style="color: black"
              >Cadastrar</n-button
            >
          </div>
        </card>
      </div>
      <div class="col text-center"></div>
    </div>
  </div>
</template>
<script>
import { Card, FormGroupInput, Button } from "@/components";

export default {
  components: {
    Card,
    [Button.name]: Button,
    [FormGroupInput.name]: FormGroupInput,
  },
};
</script>
<style></style>
