<script setup>
import {onMounted, ref} from "vue";
import { useRemoteData } from "@/composables/useRemoteData.js";

const formDataRef = ref({
  "name": "",
  "available": true
});

const urlRef = ref("http://localhost:9090/api/regions/newRegion");
const authRef = ref(true);
const methodRef = ref("POST");

const { data, performRequest } = useRemoteData(urlRef, authRef, methodRef, formDataRef);

const onSubmit = () => {
  performRequest();
  clearFormFields();
};

const clearFormFields = () => {
  formDataRef.value = {
    "name": "",
    "available": true
  };
};


</script>

<template>
  <div class="container mb-4">
    <h1>New Region</h1>
  </div>

  <div class="container mb-4">
    <div class="mb-2">
      <label for="name">Name</label>
      <input class="form-control" id="name" v-model="formDataRef.name" type="text" />
    </div>
    <div class="">
      <button class="btn btn-primary" @click="onSubmit" type="button">Create new Region</button>
    </div>
  </div>
</template>