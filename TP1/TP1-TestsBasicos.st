TestCase subclass: #PresentacionTests
	instanceVariableNames: ''
	classVariableNames: ''
	poolDictionaries: ''
	category: 'TP1-TestsBasicos'!

!PresentacionTests methodsFor: 'CreacionDePresentaciones' stamp: 'Pablito 4/2/2014 21:26'!
test01PresentacionEsCreadaVacia

| presentacion  |

presentacion := self crearPresentacion.

self assert: ((presentacion contenidoComoString) = '').
! !

!PresentacionTests methodsFor: 'CreacionDePresentaciones' stamp: 'Pablito 4/2/2014 21:30'!
test02PresentacionConUnaDiapositiva

| presentacion diapo |

presentacion := self crearPresentacion.
diapo := self crearDiapositiva.

presentacion agregarDiapositiva: diapo.

self assert: ((presentacion contenidoComoString) = 'D[]').
! !

!PresentacionTests methodsFor: 'CreacionDePresentaciones' stamp: 'Pablito 4/2/2014 21:30'!
test03PresentacionConUnaDiapositivaYPlantilla

| presentacion diapo |

presentacion := self crearPresentacion.
diapo := self crearDiapositiva.

diapo setearPlantilla: (self crearPlantillaXML).

presentacion agregarDiapositiva: diapo.

self assert: ((presentacion contenidoComoString) = '<diapositiva></diapositiva>').
! !

!PresentacionTests methodsFor: 'CreacionDePresentaciones' stamp: 'Pablito 4/2/2014 21:31'!
test04PresentacionConContenido

| presentacion diapo |

presentacion := self crearPresentacion.
diapo := self crearDiapositiva.

diapo agregarContenido: (self crearTexto: 'Hola Mundo').

presentacion agregarDiapositiva: diapo.

self assert: ((presentacion contenidoComoString) = 'D[Texto[Hola Mundo]]').
! !

!PresentacionTests methodsFor: 'CreacionDePresentaciones' stamp: 'Pablito 4/2/2014 21:31'!
test05PresentacionConContenidoYPlantilla

| presentacion diapo |

presentacion := self crearPresentacion.
diapo := self crearDiapositiva.

diapo setearPlantilla: (self crearPlantillaMayusculas).

diapo agregarContenido: (self crearTexto: 'Hola Mundo').
diapo agregarContenido: (self crearTexto: 'Chau Mundo').

presentacion agregarDiapositiva: diapo.

self assert: ((presentacion contenidoComoString) = 'D[Texto[HOLA MUNDO]Texto[CHAU MUNDO]]').
! !

!PresentacionTests methodsFor: 'CreacionDePresentaciones' stamp: 'Pablito 4/2/2014 21:31'!
test06PresentacionConTransicionPorDefecto

| presentacion diapo1 diapo2 |

presentacion := self crearPresentacion.
diapo1 := self crearDiapositiva.
diapo2 := self crearDiapositiva.

diapo1 setearPlantilla: (self crearPlantillaMayusculas).
diapo1 agregarContenido: (self crearTexto: 'Hola Mundo').

diapo2 setearPlantilla: (self crearPlantillaXML).
diapo2 agregarContenido: (self crearTexto: 'Chau Mundo').

presentacion agregarDiapositiva: diapo1.
presentacion agregarDiapositiva: diapo2.

self assert: ((presentacion contenidoComoString) = 'D[Texto[HOLA MUNDO]] --> <diapositiva><texto>Chau Mundo</texto></diapositiva>').
! !

!PresentacionTests methodsFor: 'CreacionDePresentaciones' stamp: 'Pablito 4/2/2014 21:31'!
test07PresentacionConTransicionBarridoHorizontal

| presentacion diapo1 diapo2 |

presentacion := self crearPresentacion.
diapo1 := self crearDiapositiva.
diapo2 := self crearDiapositiva.

diapo1 setearPlantilla: (self crearPlantillaMayusculas).
diapo1 agregarContenido: (self crearTexto: 'Hola Mundo').

diapo2 setearPlantilla: (self crearPlantillaXML).
diapo2 agregarContenido: (self crearTexto: 'Chau Mundo').

presentacion agregarDiapositiva: diapo1 conTransicion: (self crearTransicionBarridoHorizontal).
presentacion agregarDiapositiva: diapo2.

self assert: ((presentacion contenidoComoString) = 'D[Texto[HOLA MUNDO]] --BH--> <diapositiva><texto>Chau Mundo</texto></diapositiva>').
! !

!PresentacionTests methodsFor: 'CreacionDePresentaciones' stamp: 'Pablito 4/2/2014 21:32'!
test08PresentacionConDosTransiciones

| presentacion diapo1 diapo2 diapo3 |

presentacion := self crearPresentacion.
diapo1 := self crearDiapositiva.
diapo2 := self crearDiapositiva.
diapo3 := self crearDiapositiva.

diapo1 setearPlantilla: (self crearPlantillaMayusculas).
diapo1 agregarContenido: (self crearTexto: 'Hola').

diapo2 setearPlantilla: (self crearPlantillaXML).
diapo2 agregarContenido: (self crearTexto: 'Y').

diapo3 agregarContenido: (self crearTexto: 'Chau').

presentacion agregarDiapositiva: diapo1.
presentacion agregarDiapositiva: diapo2 conTransicion: (self crearTransicionBarridoVertical).
presentacion agregarDiapositiva: diapo3.

self assert: ((presentacion contenidoComoString) = 'D[Texto[HOLA]] --> <diapositiva><texto>Y</texto></diapositiva> --BV--> D[Texto[Chau]]').
! !


!PresentacionTests methodsFor: 'CopiarYPegar' stamp: 'Pablito 4/2/2014 21:32'!
test09CopiarDiapositivaMantienePlantillaPeroNoTransicion

| presentacion1 presentacion2 diapo1 diapo2 diapo3 comandoCopiar |

presentacion1 := self crearPresentacion.
diapo1 := self crearDiapositiva.
diapo2 := self crearDiapositiva.

diapo1 setearPlantilla: (self crearPlantillaMayusculas).
diapo1 agregarContenido: (self crearTexto: 'Hola').

diapo2 agregarContenido: (self crearTexto: 'Chau').

presentacion1 agregarDiapositiva: diapo1 conTransicion: (self crearTransicionBarridoVertical).
presentacion1 agregarDiapositiva: diapo2. 

self assert: ((presentacion1 contenidoComoString) = 'D[Texto[HOLA]] --BV--> D[Texto[Chau]]').

presentacion2 := self crearPresentacion.

diapo3 := self crearDiapositiva.
diapo3 agregarContenido: (self crearTexto: 'De nuevo').

comandoCopiar := self crearComandoCopiar.

comandoCopiar copiar: (presentacion1 obtenerDiapositivaNro: 1).
comandoCopiar pegarAlFinalDe: presentacion2.

presentacion2 agregarDiapositiva: diapo3.

self assert: ((presentacion1 contenidoComoString) = 'D[Texto[HOLA]] --BV--> D[Texto[Chau]]').

self assert: ((presentacion2 contenidoComoString) = 'D[Texto[HOLA]] --> D[Texto[De nuevo]]').
! !

!PresentacionTests methodsFor: 'CopiarYPegar' stamp: 'Pablito 4/2/2014 21:33'!
test10CopiarDiapositivaCreaUnaCopiaIndependienteDeLaOriginal

| presentacion1 presentacion2 diapo1 diapo1Copiada comandoCopiar |

presentacion1 := self crearPresentacion.
diapo1 := self crearDiapositiva.

diapo1 setearPlantilla: (self crearPlantillaMayusculas).
diapo1 agregarContenido: (self crearTexto: 'Hola').

presentacion1 agregarDiapositiva: diapo1.

self assert: ((presentacion1 contenidoComoString) = 'D[Texto[HOLA]]').

presentacion2 := self crearPresentacion.

comandoCopiar := self crearComandoCopiar.

comandoCopiar copiar: (presentacion1 obtenerDiapositivaNro: 1).
comandoCopiar pegarAlFinalDe: presentacion2.

self assert: ((presentacion2 contenidoComoString) = 'D[Texto[HOLA]]').

diapo1Copiada := presentacion2 obtenerDiapositivaNro: 1.
diapo1Copiada agregarContenido: (self crearTexto: 'Chau').

self assert: ((presentacion1 contenidoComoString) = 'D[Texto[HOLA]]').

self assert: ((presentacion2 contenidoComoString) = 'D[Texto[HOLA]Texto[CHAU]]').

! !

!PresentacionTests methodsFor: 'CopiarYPegar' stamp: 'Pablito 4/2/2014 21:34'!
test11CortarDiapositivaRemueveLaDiapositivaDeLaPresentacion

| presentacion1 presentacion2 diapo1 comandoCortar |

presentacion1 := self crearPresentacion.
diapo1 := self crearDiapositiva.

diapo1 setearPlantilla: (self crearPlantillaMayusculas).
diapo1 agregarContenido: (self crearTexto: 'Hola').

presentacion1 agregarDiapositiva: diapo1.

self assert: ((presentacion1 contenidoComoString) = 'D[Texto[HOLA]]').

presentacion2 := self crearPresentacion.

comandoCortar := self crearComandoCortar.

comandoCortar cortar: (presentacion1 obtenerDiapositivaNro: 1).
comandoCortar pegarAlFinalDe: presentacion2.

self assert: ((presentacion1 contenidoComoString) = '').

self assert: ((presentacion2 contenidoComoString) = 'D[Texto[HOLA]]').

! !


!PresentacionTests methodsFor: 'Auxiliares' stamp: 'x 4/1/2014 12:13'!
crearComandoCopiar

	^ ComandoCopiar new.
! !

!PresentacionTests methodsFor: 'Auxiliares' stamp: 'x 4/1/2014 12:23'!
crearComandoCortar

	^ ComandoCortar new.
! !

!PresentacionTests methodsFor: 'Auxiliares' stamp: 'aaa 3/30/2014 20:08'!
crearDiapositiva
	
	^ Diapositiva new.! !

!PresentacionTests methodsFor: 'Auxiliares' stamp: 'x 3/31/2014 12:25'!
crearPlantillaMayusculas

	^ PlantillaMayusculas new.
	! !

!PresentacionTests methodsFor: 'Auxiliares' stamp: 'x 3/31/2014 12:08'!
crearPlantillaXML
	
	^ PlantillaXML new.
! !

!PresentacionTests methodsFor: 'Auxiliares' stamp: 'aaa 3/30/2014 12:01'!
crearPresentacion
	
	^ Presentacion new.! !

!PresentacionTests methodsFor: 'Auxiliares' stamp: 'x 3/31/2014 12:13'!
crearTexto: unString

	^ Texto conString: unString.
	! !

!PresentacionTests methodsFor: 'Auxiliares' stamp: 'x 3/31/2014 12:56'!
crearTransicionBarridoHorizontal

	^ TransicionBarridoHorizontal new.! !

!PresentacionTests methodsFor: 'Auxiliares' stamp: 'x 3/31/2014 12:57'!
crearTransicionBarridoVertical

	^ TransicionBarridoVertical new.
	! !
