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
      <h4 class="title text-center">Cadastrar Dados</h4>
    </div>
    <signup-form></signup-form>
    <br>
  </div>
</template>
<script>
import SignupForm from "./components/SignupForm";

export default {
  name: "profileadd",
  bodyClass: "profile-page",
  components: {
    SignupForm
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
    background-color: #2CA8FF;
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
</style>
