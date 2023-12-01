# Build
custom_build(
    # Name of the container image
    ref = 'catalog-service',
    # Command to build the container image
    # mvn spring-boot:build-image
    command = './mvnw spring-boot:build-image -Dspring-boot.build-image.builder=ghcr.io/thomasvitale/java-builder-arm64  -Dmodule.image.name=$EXPECTED_REF',
    # Files to watch that trigger a new build
    deps = ['pom.xml', 'src']
)
# Deploy
k8s_yaml(['k8s/deployment.yml', 'k8s/service.yml'])
# Manage
k8s_resource('catalog-service', port_forwards=['9001'])
