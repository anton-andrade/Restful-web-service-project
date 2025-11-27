# RESTful Web Service Project
This project is an ongoing coursework piece for a Service‑Centric Cloud Computing module. It implements a RESTful web service that integrates with the public OSRM (Open Source Routing Machine) API to provide distance and duration data between waypoints via a clean HTTP interface.

## Technologies
- Java
- JAX‑RS (`javax.ws.rs') for RESTful endpoints
- Java `HttpClient` / `HttpURLConnection` for outbound HTTP calls
- Jackson (`ObjectMapper`) for JSON parsing and serialisation

## Architecture and Features
- `OsrmService` JAX‑RS resource exposed under `/webresources/osrm` that accepts a `coords` query parameter and forwards requests to the OSRM (Table) API.
- Input validation on the `coords` parameter with structured JSON error messages for missing or failed requests.
- Domain model classes (`Response`, `Waypoint`) used to map OSRM JSON into Java objects and then serialise back to JSON for clients.
- `ApplicationConfig` registers REST resources and defines the base `webresources` application path.
- Stand‑alone `Client` class that calls the local REST API, deserialises the JSON response, and prints selected fields (e.g. distances between waypoints).

## Example
The service exposes a GET endpoint of the form: `GET /webresources/osrm?coords=lon1,lat1;lon2,lat2`

The `Client` class demonstrates how to call this endpoint on `http://localhost:9090` and consume the returned JSON distance matrix.
