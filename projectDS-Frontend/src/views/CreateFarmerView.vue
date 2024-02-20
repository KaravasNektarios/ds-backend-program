<script setup>
import { ref } from "vue";
import { useRemoteData } from "@/composables/useRemoteData.js";

const formDataRef = ref({
  "firstName": "",
  "lastName": "",
  "username": "",
  "email": "",
  "password": "",
  "phone": ""
});

const urlRef = ref("http://localhost:9090/api/farmers/newFarmer");
const authRef = ref(true);
const methodRef = ref("POST");

const { data, performRequest } = useRemoteData(urlRef, authRef, methodRef, formDataRef);

const onSubmit = () => {
  performRequest();

  clearFormFields();
};

const clearFormFields = () => {
  formDataRef.value = {
    "firstName": "",
    "lastName": "",
    "username": "",
    "email": "",
    "password": "",
    "phone": ""
  };
};


</script>

<template>
  <div class="container mb-4">
    <h1>New Farmer</h1>
  </div>
  <div>
<!--    <pre>{{ data }}</pre>-->
  </div>
  <div class="container mb-4">
    <div class="mb-2">
      <label for="firstName">First Name</label>
      <input class="form-control" id="firstName" v-model="formDataRef.firstName" type="text" />
    </div>
    <div class="mb-2">
      <label for="lastName">Last Name</label>
      <input class="form-control" id="lastName" v-model="formDataRef.lastName" type="text" />
    </div>
    <div class="mb-2">
      <label for="username">Username</label>
      <input class="form-control" id="username" v-model="formDataRef.username" type="text" />
    </div>
    <div class="mb-2">
      <label for="email">Email</label>
      <input class="form-control" id="email" v-model="formDataRef.email" type="email" />
    </div>
    <div class="mb-2">
      <label for="password">Password</label>
      <input class="form-control" id="password" v-model="formDataRef.password" type="password" />
    </div>
    <div class="mb-2">
      <label for="phone">Phone</label>
      <input class="form-control" id="phone" v-model="formDataRef.phone" type="text" />
    </div>
    <div class="">
      <button class="btn btn-primary" @click="onSubmit" type="button">Create new Farmer</button>
    </div>
  </div>
</template>