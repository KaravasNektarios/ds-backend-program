<script setup>
import { onMounted, ref } from 'vue';
import { useRemoteData } from '@/composables/useRemoteData.js';
import {RouterLink} from "vue-router";

const urlRef = ref('http://localhost:9090/api/requests');
const authRef = ref(true);
const { data, loading, performRequest } = useRemoteData(urlRef, authRef);

onMounted(() => {
  performRequest();
});
</script>

<template>
  <div class="bg-body-tertiary">
    <div class="container">
      <div class="row py-4 px-3">
        <div class="col-12">
          <div class="mb-4">
            <h1 class="fs-3">Requests</h1>
          </div>
          <div>
            <table class="table">
              <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Status</th>
                <th>Details</th>
                <th>Farmers</th>
                <th>Products</th>
                <th>Region</th>
                <th>Actions</th>

              </tr>
              </thead>
              <tbody v-if="loading">
              <tr>
                <td colspan="5">Loading...</td>
              </tr>
              </tbody>
              <tbody v-if="data">
              <tr v-for="request in data">
                <td>{{ request.id }}</td>
                <td>{{ request.name }}</td>
                <td>{{ request.status }}</td>
                <td>{{ request.details }}</td>
                <td>{{ request.farmers }}</td>
                <td>{{ request.products }}</td>
                <td>{{ request.region }}</td>
                <td>
                  <RouterLink :to="{ name: 'delete-request', params: { id: request.id } }"
                  >Delete</RouterLink>
                </td>

              </tr>

              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
