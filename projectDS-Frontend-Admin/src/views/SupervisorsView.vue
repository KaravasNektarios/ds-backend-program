<script setup>
import { onMounted, ref } from 'vue';
import { useRemoteData } from '@/composables/useRemoteData.js';
import {RouterLink} from "vue-router";

const urlRef = ref('http://localhost:9090/api/supervisors');
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
            <h1 class="fs-3">Supervisors</h1>
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
              <tr v-for="supervisor in data">
                <td>{{ supervisor.id }}</td>
                <td>{{ supervisor.firstName }}</td>
                <td>{{ supervisor.lastName }}</td>
                <td>{{ supervisor.username }}</td>
                <td>{{ supervisor.email }}</td>
                <td>{{ supervisor.phone }}</td>

                <td>
                  <RouterLink :to="{ name: 'delete-supervisor', params: { id: supervisor.id } }"
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
