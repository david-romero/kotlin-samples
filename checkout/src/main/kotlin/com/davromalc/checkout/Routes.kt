import com.davromalc.checkout.CheckoutHandler
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.router

fun routes(checkoutHandler: CheckoutHandler) =
        router {
            ("/api/checkout" and accept(APPLICATION_JSON))
                    .nest {
                        POST("/{cartId}", checkoutHandler::execute)
                    }
        }
