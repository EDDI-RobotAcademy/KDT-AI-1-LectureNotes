import React, {useEffect} from 'react'
import { navigationMount } from 'vueNavigationApp/VueNavigation'

const NavigationComponent = ({ vuetifyNavigationRef }) => {
  useEffect(() => {
    navigationMount(vuetifyNavigationRef.current)
  })

  return <div ref={vuetifyNavigationRef}/>

}

export default NavigationComponent