<script setup>
import { onMounted, ref } from 'vue';
import { useRemoteData } from '@/composables/useRemoteData.js';
import {RouterLink} from "vue-router";

const urlRef = ref('http://localhost:9090/api/farmers');
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
            <h1 class="fs-3">Farmers</h1>
          </div>
          <div>
            <table class="table">
              <thead>
              <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Actions</th>
              </tr>
              </thead>
              <tbody v-if="loading">
              <tr>
                <td colspan="5">Loading...</td>
              </tr>
              </tbody>
              <tbody v-if="data">
              <tr v-for="farmer in data" :key="farmer.id">
                <td>{{ farmer.id }}</td>
                <td>{{ farmer.firstName }}</td>
                <td>{{ farmer.lastName }}</td>
                <td>{{ farmer.username }}</td>
                <td>{{ farmer.email }}</td>
                <td>{{ farmer.phone }}</td>
                <td>
                  <RouterLink :to="{ name: 'delete-farmer', params: { id: farmer.id } }"
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
