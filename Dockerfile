FROM public.ecr.aws/lambda/java:17

# Copy function code and runtime dependencies from Maven layout
COPY target/classes ${LAMBDA_TASK_ROOT}
COPY lib_bkp/* ${LAMBDA_TASK_ROOT}/lib/
COPY target/dependency/* ${LAMBDA_TASK_ROOT}/lib/


COPY ssl/* /opt/
RUN keytool -import -noprompt -trustcacerts -alias RootCA -file /opt/RootCA.crt -storepass changeit -keystore /var/lang/lib/security/cacerts

RUN yum update -y

RUN mkdir chrome
COPY chrome/* /chrome/
RUN yum install  /chrome/vulkan-filesystem-1.0.61.1-2.amzn2.noarch.rpm -y
RUN yum install  /chrome/vulkan-1.0.61.1-2.amzn2.x86_64.rpm -y
RUN yum install  /chrome/google-chrome-stable-116.0.5845.96-1.x86_64.rpm -y

RUN google-chrome-stable --version

RUN cp /opt/RootCA.crt /etc/pki/ca-trust/source/anchors/
RUN update-ca-trust force-enable
RUN update-ca-trust extract

# Set the CMD to your handler (could also be done as a parameter override outside of the Dockerfile)
CMD [ "org.lambda.test.LambdaRunner::handleRequest" ]