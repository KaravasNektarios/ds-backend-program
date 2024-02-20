<script setup>
import { ref } from "vue";
import { useRemoteData } from "@/composables/useRemoteData.js";

const formDataRef = ref({
  "name": "",
  "farmersId": [],
  "productsId": [],
  "regionId": ""
});

const urlRef = ref("http://localhost:9090/api/requests/newRequest");
const authRef = ref(true);
const methodRef = ref("POST");

const { data, performRequest } = useRemoteData(urlRef, authRef, methodRef, formDataRef);

const onSubmit = () => {
  formDataRef.value.farmersId = formDataRef.value.farmersId.split(',').map(Number);
  formDataRef.value.productsId = formDataRef.value.productsId.split(',').map(Number);
  formDataRef.value.regionId = parseInt(formDataRef.value.regionId);
  performRequest();
  clearFormFields();
};


const clearFormFields = () => {
  formDataRef.value = {
    "name": "",
    "farmersId": [],
    "productsId": [],
    "regionId": ""
  };
};
</script>


<template>
  <div class="container mb-4">
    <h1>New Request</h1>
  </div>
  <div>
<!--    <pre>{{ data }}</pre>-->
  </div>
  <div class="container mb-4">
    <div class="mb-2">
      <label for="name">Name</label>
      <input class="form-control" id="name" v-model="formDataRef.name" type="text" />
    </div>
    <div class="mb-2">
      <label for="farmersId">Farmers ID</label>
      <input class="form-control" id="farmersId" v-model="formDataRef.farmersId" type="text" />
    </div>
    <div class="mb-2">
      <label for="productsId">Products ID</label>
      <input class="form-control" id="productsId" v-model="formDataRef.productsId" type="text" />
    </div>
    <div class="mb-2">
      <label for="regionId">Region ID</label>
      <input class="form-control" id="regionId" v-model="formDataRef.regionId" type="text" />
    </div>
    <div class="">
      <button class="btn btn-primary" @click="onSubmit" type="button">Create new Request</button>
    </div>
  </div>
</template>