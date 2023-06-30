import { vuetifyTailwindBoardAppMount } from "../bootstrap"
import router from '../router'

const modifyBootstrapMount = (el) => {
  const vueBoardApp = vuetifyTailwindBoardAppMount(el)

  const newRoute = {
    name: 'VuetifyBoardModify',
  }

  router.push(newRoute)
}

export { modifyBootstrapMount }