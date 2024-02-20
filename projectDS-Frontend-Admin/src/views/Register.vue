<script setup>
import { ref } from "vue";
import { useRemoteData } from "@/composables/useRemoteData.js";

const formDataRef = ref({
  "username": "",
  "email": "",
  "role": [],
  "password": ""
});
const urlRef = ref("http://localhost:9090/api/auth/signupadmin");
const authRef = ref(false);
const methodRef = ref("POST");

const { data, performRequest } = useRemoteData(urlRef, authRef, methodRef, formDataRef);

const onSubmit = () => {
  performRequest();
  clearFormFields();
};

const clearFormFields = () => {
  formDataRef.value = {
    "username": "",
    "email": "",
    "role":[],
    "password": ""
  };
};


</script>

<template>
  <div class="container mb-4">
    <h1>New User</h1>
  </div>
  <div class="container mb-4">
    <div class="mb-2">
      <label for="username">Username</label>
      <input class="form-control" id="username" v-model="formDataRef.username" type="text" />
    </div>
    <div class="mb-2">
      <label for="email">Email</label>
      <input class="form-control" id="email" v-model="formDataRef.email" type="email" />
    </div>

    <div class="mb-2">
      <label for="role">Role</label>
      <select class="form-control" id="role" v-model="formDataRef.role" multiple>
        <option value="admin">Admin</option>
        <option value="supervisor">Supervisor</option>
        <option value="user">User</option>
      </select>
    </div>


    <div class="mb-2">
      <label for="password">Password</label>
      <input class="form-control" id="password" v-model="formDataRef.password" type="password" />
    </div>

    <div class="">
      <button class="btn btn-primary" @click="onSubmit" type="button">Create new User</button>
    </div>
  </div>
</template>
