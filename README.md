# autowire-circe
Scala RPC using Autowire but with Circe for serialization instead of uPickle

To see demo:
1. `git clone https://github.com/aholland/autowire-circe.git`
2. `sbt run`
3. Browse http://localhost:9000/

The key types are:  
`Server: autowire.AutoWireServer, controllers.AutoWireController`  
`Shared: shared.autowire.SharedApi`  
`Client: client.comms.Client`  

The example call to the server is in `client.Main`in method `loadInitialData`.

AutoWire: https://github.com/lihaoyi/autowire  
uPickle: https://github.com/lihaoyi/upickle-pprint  
Circe: https://circe.github.io/circe/  

The uPickle bug which motivated the shift to Circe: https://github.com/lihaoyi/upickle-pprint/issues/168

Pull Requests welcome.
