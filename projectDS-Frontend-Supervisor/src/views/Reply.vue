<script setup>
import { ref } from "vue";
import { useRemoteData } from "@/composables/useRemoteData.js";

const formDataRef = ref({
  "status": "",
  "details": ""
});

const onSubmit = () => {

  clearFormFields();
};

const clearFormFields = () => {
  formDataRef.value = {
    "status": "",
    "details": ""
  };
};


</script>

<template>
  <div class="container mb-4">
    <h1>Reply</h1>
  </div>

  <div class="container mb-4">
    <div class="mb-2">
      <label for="status">Status</label>
      <input class="form-control" id="status" v-model="formDataRef.status" type="text" />
    </div>
    <div class="mb-2">
      <label for="details">Details</label>
      <input class="form-control" id="details" v-model="formDataRef.details" type="text" />
    </div>

    <div class="">
      <button class="btn btn-primary" @click="onSubmit" type="button">Reply</button>
    </div>
  </div>
</template>