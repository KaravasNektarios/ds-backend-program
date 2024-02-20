<script setup>
import { ref, computed, onMounted } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import { useRemoteData } from '@/composables/useRemoteData.js';

const router = useRouter();
const route = useRoute();

const farmerIdRef = ref(null);

const urlRef = computed(() => {
  return 'http://localhost:9090/api/farmers/' + farmerIdRef.value;
});
const authRef = ref(true);
const { data, loading, performRequest } = useRemoteData(urlRef, authRef);

onMounted(() => {
  farmerIdRef.value = route.params.id;
  performRequest();
});
</script>


<template>
  <div class="bg-body-tertiary">
    <div class="container">
      <div class="row py-4 px-3">
        <div class="col-12">
          <div class="mb-4">
            <RouterLink class="small" :to="{ name: 'farmers' }"
            >Back to Farmers</RouterLink
            >
            <h1 class="fs-3">Farmer #{{ farmerIdRef }}</h1>
          </div>
          <hr>
          <h3>Information: </h3>
          <br>

<!--          <p>{{ data }}</p>-->

          <tbody v-if="data">
          <tr>
            <td><strong>ID: </strong>{{ data.id }}</td>
          </tr>
          <tr>
            <td><strong>First Name: </strong>{{ data.firstName }}</td>
          </tr>
          <tr>
            <td><strong>Last Name: </strong>{{ data.lastName }}</td>
          </tr>
          <tr>
            <td><strong>Username: </strong>{{ data.username }}</td>
          </tr>
          <tr>
            <td><strong>Email: </strong>{{ data.email }}</td>
          </tr>
          <tr>
            <td><strong>Phone: </strong>{{ data.phone }}</td>
          </tr>

          <tr>
            <td><strong>Region: </strong>{{ data.region }}</td>
          </tr>

          </tbody>
          <div>
            <router-view></router-view>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
