import { createRouter, createWebHistory } from 'vue-router';
// import HomeView from '../views/HomeView.vue';
import { useApplicationStore } from '@/stores/application.js';

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            // component: HomeView,
            component: () => import('../views/HomeView.vue'),
            meta: { requiresAuth: true }
        },
        {
            path: '/profile',
            name: 'profile',
            component: () => import('../views/ProfileView.vue'),
            meta: { requiresAuth: true }
        },
        {
            path: '/farmers',
            name: 'farmers',
            component: () => import('../views/FarmersView.vue'),
            meta: { requiresAuth: true }
        },
        {
            path: '/products',
            name: 'products',
            component: () => import('../views/ProductsView.vue'),
            meta: { requiresAuth: true }
        },
        {
            path: '/regions',
            name: 'regions',
            component: () => import('../views/RegionsView.vue'),
            meta: { requiresAuth: true }
        },
        {
            path: '/supervisors',
            name: 'supervisors',
            component: () => import('../views/SupervisorsView.vue'),
            meta: { requiresAuth: true }
        },
        {
            path: '/farmers/new',
            name: 'farmer-new',
            component: () => import('../views/CreateFarmerView.vue'),
            meta: { requiresAuth: true }
        },
        {
            path: '/products/new',
            name: 'product-new',
            component: () => import('../views/CreateProductView.vue'),
            meta: { requiresAuth: true }
        },
        {
            path: '/regions/new',
            name: 'region-new',
            component: () => import('../views/CreateRegionView.vue'),
            meta: { requiresAuth: true }
        },
        {
            path: '/supervisors/new',
            name: 'supervisor-new',
            component: () => import('../views/CreateSupervisorView.vue'),
            meta: { requiresAuth: true }
        },
        {
            path: '/farmers/:id',
            name: 'delete-farmer',
            component: () => import('../views/DeleteFarmerView.vue'),
            meta: { requiresAuth: true },
        },
        {
            path: '/products/:id',
            name: 'delete-product',
            component: () => import('../views/DeleteProductView.vue'),
            meta: { requiresAuth: true },
        },
        {
            path: '/regions/:id',
            name: 'delete-region',
            component: () => import('../views/DeleteRegionView.vue'),
            meta: { requiresAuth: true },
        },

        {
            path: '/requests',
            name: 'requests',
            component: () => import('../views/RequestsView.vue'),
            meta: { requiresAuth: true }
        },
        {
            path: '/register',
            name: 'register',
            component: () => import('../views/Register.vue'),
            meta: { requiresAuth: false }
        },
        {
            path: '/supervisors/:id',
            name: 'delete-supervisor',
            component: () => import('../views/DeleteSupervisorView.vue'),
            meta: { requiresAuth: true },
        },
        {
            path: '/requests/:id',
            name: 'delete-request',
            component: () => import('../views/DeleteRequestView.vue'),
            meta: { requiresAuth: true },
        },
        {
            path: '/login',
            name: 'login',
            component: () => import('../views/LoginView.vue')
        },
        {
            path: '/logout',
            name: 'logout',
            component: () => import('../views/LogoutView.vue'),
            meta: { requiresAuth: true }
        }
    ]
});

router.beforeEach((to, from, next) => {
    const { isAuthenticated } = useApplicationStore();
    const requiresAuth = to.matched.some((record) => record.meta.requiresAuth);

    if (requiresAuth && !isAuthenticated) {
        console.log('user not authenticated. redirecting to /login');
        next('/login');
    } else {
        next();
    }
});

export default router;
