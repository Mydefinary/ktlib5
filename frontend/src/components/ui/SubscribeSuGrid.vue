<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
            </div>
            <SubscribeList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></SubscribeList>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>bookId</th>
                        <th>userId</th>
                        <th>SubscribedAt</th>
                        <th>ExpriedAt</th>
                        <th>PaymentAt</th>
                        <th>PaymentSuccess</th>
                        <th>ReadCost</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="bookId">{{ val.bookId }}</td>
                            <td class="whitespace-nowrap" label="userId">{{ val.userId }}</td>
                            <td class="whitespace-nowrap" label="SubscribedAt">{{ val.subscribedAt }}</td>
                            <td class="whitespace-nowrap" label="ExpriedAt">{{ val.expriedAt }}</td>
                            <td class="whitespace-nowrap" label="PaymentAt">{{ val.paymentAt }}</td>
                            <td class="whitespace-nowrap" label="PaymentSuccess">{{ val.paymentSuccess }}</td>
                            <td class="whitespace-nowrap" label="ReadCost">{{ val.readCost }}</td>
                            <v-row class="ma-0 pa-4 align-center">
                                <v-spacer></v-spacer>
                                <Icon style="cursor: pointer;" icon="mi:delete" @click="deleteRow(val)" />
                            </v-row>
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">SubscribeSu 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <SubscribeSu :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">SubscribeSu 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="SubscriptionId" v-model="selectedRow.subscriptionId" :editMode="true"/>
                            <Number label="bookId" v-model="selectedRow.bookId" :editMode="true"/>
                            <Number label="userId" v-model="selectedRow.userId" :editMode="true"/>
                            <Date label="SubscribedAt" v-model="selectedRow.subscribedAt" :editMode="true"/>
                            <Date label="ExpriedAt" v-model="selectedRow.expriedAt" :editMode="true"/>
                            <Date label="PaymentAt" v-model="selectedRow.paymentAt" :editMode="true"/>
                            <Boolean label="PaymentSuccess" v-model="selectedRow.paymentSuccess" :editMode="true"/>
                            <Number label="ReadCost" v-model="selectedRow.readCost" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'


export default {
    name: 'subscribeSuGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'subscribeSus',
    }),
    watch: {
    },
    methods:{
    }
}

</script>