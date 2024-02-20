<script setup>
import { ref, computed, onMounted } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import { useRemoteData } from '@/composables/useRemoteData.js';

const router = useRouter();
const route = useRoute();

const regionIdRef = ref(null);

const urlRef = computed(() => {
  return 'http://localhost:9090/api/regions/' + regionIdRef.value;
});
const authRef = ref(true);
const { data, loading, performRequest } = useRemoteData(urlRef, authRef);

onMounted(() => {
  regionIdRef.value = route.params.id;
  performRequest();
});
</script>


<template>
  <div class="bg-body-tertiary">
    <div class="container">
      <div class="row py-4 px-3">
        <div class="col-12">
          <div class="mb-4">
            <RouterLink class="small" :to="{ name: 'regions' }"
            >Back to Regions</RouterLink
            >
            <h1 class="fs-3">Region #{{ regionIdRef }}</h1>
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
            <td><strong>Name: </strong>{{ data.name }}</td>
          </tr>
          <tr>
            <td><strong>Available: </strong>{{ data.available }}</td>
          </tr>
          <tr>
            <td><strong>Products: </strong>{{ data.products }}</td>
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
