<script setup>
import { ref, computed, onMounted } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import { useRemoteData } from '@/composables/useRemoteData.js';

const router = useRouter();
const route = useRoute();

const productIdRef = ref(null);

const urlRef = computed(() => {
  return 'http://localhost:9090/api/products/deleteProductById/' + productIdRef.value;
});

const authRef = ref(true);
const methodRef = ref("DELETE");

const { data, performRequest } = useRemoteData(urlRef, authRef, methodRef);

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
            >Back to Products</RouterLink>

          </div>
          <hr>
          <br>
          <h1 class="fs-3">The Product with id: {{ productIdRef }} has been deleted</h1>

          <div>
            <router-view></router-view>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
