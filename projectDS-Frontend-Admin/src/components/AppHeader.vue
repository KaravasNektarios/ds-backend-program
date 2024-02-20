<script setup>
import { RouterLink } from 'vue-router';
import { useApplicationStore } from '@/stores/application.js';
const applicationStore = useApplicationStore();
</script>

<template>
  <header class="text-bg-dark">
    <div class="container">
      <div class="d-flex flex-wrap justify-content-center py-2 px-3">
        <a
            href="/"
            class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none"
        >
          <span class="fs-5 fw-bolder text-white">API Admin</span>
        </a>
        <ul class="nav nav-pills">
          <!-- @EXERCISE: Add different color to active link (improve UX/UX). -->
          <!-- @EXERCISE: Add different color to active link with nested routes (improve UX/UX). -->
          <!-- @EXERCISE: Hide links that users has no access to. -->
          <li class="nav-item" v-if="applicationStore.isAuthenticated === true">
            <router-link :to="{ name: 'home' }" class="nav-link text-white"
            >Home</router-link
            >
          </li>
          <li class="nav-item" v-if="applicationStore.isAuthenticated === true">
            <router-link :to="{ name: 'farmers' }" class="nav-link text-white"
            >Farmers</router-link>
          </li>

          <li class="nav-item" v-if="applicationStore.isAuthenticated === true">
            <router-link :to="{ name: 'farmer-new' }" class="nav-link text-white"
            >Create Farmer</router-link>
          </li>

          <li class="nav-item" v-if="applicationStore.isAuthenticated === true">
            <router-link :to="{ name: 'requests' }" class="nav-link text-white"
            >Requests</router-link>
          </li>


          <li class="nav-item" v-if="applicationStore.isAuthenticated === true">
            <router-link :to="{ name: 'products' }" class="nav-link text-white"
            >Products</router-link>
          </li>

          <li class="nav-item" v-if="applicationStore.isAuthenticated === true">
            <router-link :to="{ name: 'product-new' }" class="nav-link text-white"
            >Create Product</router-link>
          </li>

          <li class="nav-item" v-if="applicationStore.isAuthenticated === true">
            <router-link :to="{ name: 'regions' }" class="nav-link text-white"
            >Regions</router-link>
          </li>

          <li class="nav-item" v-if="applicationStore.isAuthenticated === true">
            <router-link :to="{ name: 'region-new' }" class="nav-link text-white"
            >Create Region</router-link>
          </li>


          <li class="nav-item" v-if="applicationStore.isAuthenticated === true">
            <router-link :to="{ name: 'supervisors' }" class="nav-link text-white"
            >Supervisors</router-link>
          </li>

          <li class="nav-item" v-if="applicationStore.isAuthenticated === true">
            <router-link :to="{ name: 'supervisor-new' }" class="nav-link text-white"
            >Create Supervisor</router-link>
          </li>


          <li class="nav-item" v-if="applicationStore.isAuthenticated === true">
            <router-link :to="{ name: 'profile' }" class="nav-link text-white"
            >Profile
              <span style="font-size: 10px"
              >({{ applicationStore.userData?.username }})</span
              ></router-link
            >
          </li>
          <li class="nav-item" v-if="applicationStore.isAuthenticated === false">
            <router-link :to="{ name: 'login' }" class="nav-link text-white"
            >Login</router-link
            >
          </li>
          <li class="nav-item" v-if="applicationStore.isAuthenticated === true">
                      <router-link :to="{ name: 'logout' }" class="nav-link text-white"
            >Logout</router-link
            >
          </li>
        </ul>
      </div>
    </div>
  </header>
</template>
