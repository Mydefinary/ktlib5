import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/authors',
      component: () => import('../components/ui/AuthorGrid.vue'),
    },
    {
      path: '/authorLists',
      component: () => import('../components/AuthorListView.vue'),
    },
    {
      path: '/manuscripts',
      component: () => import('../components/ui/ManuscriptGrid.vue'),
    },
    {
      path: '/manuscriptLists',
      component: () => import('../components/ManuscriptListView.vue'),
    },
    {
      path: '/publishes',
      component: () => import('../components/ui/PublishGrid.vue'),
    },
    {
      path: '/books',
      component: () => import('../components/ui/BookGrid.vue'),
    },
    {
      path: '/bookLists',
      component: () => import('../components/BookListView.vue'),
    },
    {
      path: '/points',
      component: () => import('../components/ui/PointGrid.vue'),
    },
    {
      path: '/pointsLists',
      component: () => import('../components/PointsListView.vue'),
    },
    {
      path: '/users',
      component: () => import('../components/ui/UserGrid.vue'),
    },
    {
      path: '/subscribeSus',
      component: () => import('../components/ui/SubscribeSuGrid.vue'),
    },
    {
      path: '/subscribeLists',
      component: () => import('../components/SubscribeListView.vue'),
    },
    {
      path: '/periodSubscribes',
      component: () => import('../components/ui/PeriodSubscribeGrid.vue'),
    },
  ],
})

export default router;
