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
            path: '/requests',
            name: 'requests',
            component: () => import('../views/RequestsView.vue'),
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
            component: () => import('../views/SupervisorView.vue'),
            meta: { requiresAuth: true }
        },
        {
            path: '/farmers/new',
            name: 'farmer-new',
            component: () => import('../views/CreateFarmerView.vue'),
            meta: { requiresAuth: true }
        },
        {
            path: '/requests/new',
            name: 'request-new',
            component: () => import('../views/CreateRequestView.vue'),
            meta: { requiresAuth: true }
        },
        {
            path: '/register',
            name: 'register',
            component: () => import('../views/Register.vue'),
            meta: { requiresAuth: false }
        },
        {
            path: '/farmers/:id',
            name: 'farmerid-details',
            component: () => import('../views/FarmerView.vue'),
            meta: { requiresAuth: true },
        },
        {
            path: '/regions/:id',
            name: 'region-details',
            component: () => import('../views/RegionView.vue'),
            meta: {requiresAuth: true},
        },
        {
            path: '/requests/:id',
            name: 'request-details',
            component: () => import('../views/RequestView.vue'),
            meta: {requiresAuth: true},
        },
        {
            path: '/products/:id',
            name: 'product-details',
            component: () => import('../views/ProductView.vue'),
            meta: { requiresAuth: true },
        },
        {
            path: '/supervisors/:id',
            name: 'super-details',
            component: () => import('../views/SupervView.vue'),
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
