import React, { useEffect } from 'react'
import { vuetifyTailwindBoardAppMount } from 'vuetifyTailwindBoardApp/VuetifyBoardBootstrap'

const VuetifyTailwindBoardComponent = ({ vuetifyTailwindBoardRef }) => {
    useEffect(() => {
      vuetifyTailwindBoardAppMount(vuetifyTailwindBoardRef.current)
    }, [])

  return <div ref={vuetifyTailwindBoardRef}/>
}

export default VuetifyTailwindBoardComponent