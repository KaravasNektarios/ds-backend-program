<script setup>
import { useApplicationStore } from '@/stores/application.js';
const { userData } = useApplicationStore();
</script>

<template>
  <div class="bg-body-tertiary">
    <div class="container">
      <div class="row py-4 px-3">
        <div class="col-12">
          <div class="mb-4">
            <h1 class="fs-3">Profile</h1>
          </div>
          <div>
            <br>
            <h4>ID: {{ userData.id }}</h4>
            <br>
            <h4>Username: {{ userData.username }}</h4>
            <br>
            <h4>Email: {{ userData.email }}</h4>
            <br>
            <h4>Role: {{ userData.roles.join(', ') }}</h4>
            <br>
            <h4>TokenType: {{ userData.tokenType }}</h4>
            <br>
            <h4>AccessToken: {{ userData.accessToken }}</h4>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>