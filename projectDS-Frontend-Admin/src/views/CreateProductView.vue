<script setup>
import {onMounted, ref} from "vue";
import { useRemoteData } from "@/composables/useRemoteData.js";

const formDataRef = ref({
  "name": "",
  "price": ""
});

const urlRef = ref("http://localhost:9090/api/products/newProduct");
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
    "price": ""
  };
};


</script>

<template>
  <div class="container mb-4">
    <h1>New Product</h1>
  </div>

  <div class="container mb-4">
    <div class="mb-2">
      <label for="name">Name</label>
      <input class="form-control" id="name" v-model="formDataRef.name" type="text" />
    </div>
    <div class="mb-2">
      <label for="price">Price</label>
      <input class="form-control" id="price" v-model="formDataRef.price" type="number" />
    </div>
    <div class="">
      <button class="btn btn-primary" @click="onSubmit" type="button">Create new Product</button>
    </div>
  </div>
</template>