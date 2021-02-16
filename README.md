# mini-context

This is a very short example of IoC frameworks. The main idea is to show how context (bean container) manages object creation, configuration or possible proxy wrapping. 

RepairCenter is the main business logic service, which has one responsibility - repair a car. 

It also contains two dependencies on Transporter - responsible for transporting an auto to repair station and deliver it back to customer, and Worker - workforce responsible for assessing car and work estimation.
There is also a Messenger which can be used by any service and responsible for sending notification or message to customer.
