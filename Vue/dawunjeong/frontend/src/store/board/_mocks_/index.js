import Vue from 'vue'
import Vuex from 'vuex'
import axiosInst from '@/utility/axiosInst'

Vue.use(Vuex)

export const getters = {

}

export const mutations = {
    fetch: jest.fn(),
}

export const actions = {
    
}

export const state = {
    
}

export function __createMocks(custom = { getters: {}, mutations: {}, actions: {}, state: {}}) {
    const mockGetters = Object.assign({}, getters, custom.getters)
    const mockMutationss = Object.assign({}, mutations, custom.mutations)
    const mockActions = Object.assign({}, actions, custom.actions)
    const mockState = Object.assign({}, state, custom.state)

    return {
        getters: mockGetters,
        mutations: mockMutationss,
        actions: mockActions,
        state: mockState,
        store: new Vuex.Store({
            getters: mockGetters,
            mutations: mockMutationss,
            actions: mockActions,
            state: mockState
        })
    }
}

export const store = __createMocks().store