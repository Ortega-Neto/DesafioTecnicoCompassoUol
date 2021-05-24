# DesafioTecnicoCompassoUol
[![Build](https://action-badges.now.sh/arildojr7/events-sample-android)]()
[![Kotlin](https://img.shields.io/badge/kotlin-powered-blue.svg)]()
[![Koin](https://img.shields.io/badge/koin-1.5.10-orange.svg)]()


## Aplicação
**DesafioTecnicoCompassoUol** é uma aplicação para o Desafio Técnico da CompassoUOL.
Nela são listados os eventos presentes na api (http://5f5a8f24d44d640016169133.mockapi.io/api/events) e é possível verificar as informações do evento, fazer check-in e compartilhar o link do evento.

## Arquitetura
Nesta aplicação foi utilizada a arquitetura **MVVM**.

## Frameworks e Bibliotecas
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- [Koin](https://github.com/InsertKoinIO/koin)
- [Glide](https://github.com/bumptech/glide)
- [Retrofit](https://github.com/square/retrofit)
- [OkHttp](https://square.github.io/okhttp/)
- [Recyclerview (ViewModel, Lifecycle, ReclyclerView, Navigation, DataBinding e CardView)](https://developer.android.com/jetpack)
- [Sweet Alert Dialog](https://github.com/pedant/sweet-alert-dialog)
- [AndroidX](https://developer.android.com/jetpack/androidx)

## Aplicação rodando
![](video/executando.gif)

## Erro com o Safe Args
Devido ao tempo de entrega e a um problema sem solução encontrada no Safe Args da navigation, estou passando as informações entre os fragments via uma variável global do evento selecionado. Caso eu não tivesse este problema, passaria a informação entre os fragments via Safe Args e usaria normalmente.
