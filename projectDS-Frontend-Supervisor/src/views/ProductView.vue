<script setup>
import { ref, computed, onMounted } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import { useRemoteData } from '@/composables/useRemoteData.js';

const router = useRouter();
const route = useRoute();

const productIdRef = ref(null);

const urlRef = computed(() => {
  return 'http://localhost:9090/api/products/' + productIdRef.value;
});
const authRef = ref(true);
const { data, loading, performRequest } = useRemoteData(urlRef, authRef);

onMounted(() => {
  productIdRef.value = route.params.id;
  performRequest();
});
</script>


<template>
  <div class="bg-body-tertiary">
    <div class="container">
      <div class="row py-4 px-3">
        <div class="col-12">
          <div class="mb-4">
            <RouterLink class="small" :to="{ name: 'products' }"
            >Back to Products</RouterLink
            >
            <h1 class="fs-3">Product #{{ productIdRef }}</h1>
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
            <td><strong>Price: </strong>${{ data.price }}</td>
          </tr>
          <tr>
            <td><strong>Farmers: </strong>{{ data.farmers }}</td>
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
