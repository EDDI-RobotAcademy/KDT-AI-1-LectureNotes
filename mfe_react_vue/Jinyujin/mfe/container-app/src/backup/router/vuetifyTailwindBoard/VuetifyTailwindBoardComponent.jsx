import React, { useEffect } from 'react'
import { vuetifyTailwindBoardAppMount } from 'vuetifyTailwindBoardApp/vuetifyBoardBootstrap'

const VuetifyTailwindBoardComponent = ({ vuetifyTailwindBoardRef }) => {
    useEffect(() => {
        vuetifyTailwindBoardAppMount(vuetifyTailwindBoardRef.current) // mount 호출해서 ref값의 현재 상태 받아옴
}, [])

  return (
      <div ref={vuetifyTailwindBoardRef}/>
    )
}

export default VuetifyTailwindBoardComponent