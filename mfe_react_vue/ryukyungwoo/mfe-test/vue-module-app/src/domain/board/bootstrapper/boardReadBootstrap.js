import { mount } from "../../../bootstrap"
import router from '../../../router'

const readBootstrapMount = (el, boardId) => {
  const vueBoardApp = mount(el)

  const newRoute = {
    name: 'BoardReadPage',
    params: {
      boardId: boardId,
    }
  }

  router.push(newRoute)
}

export { readBootstrapMount }