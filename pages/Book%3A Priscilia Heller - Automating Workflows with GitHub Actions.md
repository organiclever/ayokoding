content-origin:: external
content-status:: wip
content-authors:: [[Priscilia Heller]]
lang:: en
type:: content

- Topics
  - [[GitHub Actions]]
  - [[CI/CD]]
  - [[Continuous Integration (CI)]]
  - [[Continuous Delivery (CD)]]
- Tags
  - [[Book]]
- Publisher
  - [[Packt Publishing]]
- #target-audience
  - [[Entry Level Programmer]]
- Read on
  - [[O'Reilly Book]]
    - https://www.oreilly.com/library/view/automating-workflows-with/9781800560406/
- Summary
  - Chapter 1 - learning the foundations of [[GitHub Actions]]
    - Introduces [[GitHub]], [[YAML]], and other concepts that are the foundation of [[GitHub Actions]]
  - Chapter 2 - deep diving into [[GitHub Actions]]
    - Presents specific concepts, components, and characteristics of [[GitHub Actions]] in more detail.
  - Chapter 3 - a closer look at workflows
    - Presents in-depth information about workflows, the core of [[GitHub Actions]]. This chapter includes several real-life examples.
  - Chapter 4 - working with self-hosted runners
    - Gives an overview of what self-hosted runners are, how to create an environment to host runners, and creating a workflow that uses a self-hosted runner.
  - Chapter 5 - writing your own actions
    - Guides you on creating actions of all three kinds: Docker, JavaScript, and composite run steps.
  - Chapter 6 - marketplace: finding existing actions and publishing your owns
    - Guides you on how to find existing actions that were created by the GitHub Actions community, and how to publish actions that you create.
  - Chapter 7 - migrations
    - Looks at how to migrate from other CI/CD platforms such as Azure Pipelines, GitLab CI/CD, and Jenkins into GitHub Actions.
  - Chapter 8 - contributing to the community and finding help
    - Covers how you can participate in the GitHub Actions community to both ask for and offer help.
  - Chapter 9 - the future of [[GitHub Actions]]
    - Takes a look at the public GitHub roadmap and highlights GitHub Actions features that will be added in the future.
- Resources
  - [Repository](https://github.com/PacktPublishing/Automating-Workflows-with-GitHub-Actions)
  - [Color Images](http://www.packtpub.com/sites/default/files/downloads/9781800560406_ColorImages.pdf)
- Chapter 1 - Learning the Foundations for GitHub Actions
  - A brief trip through the history of software development
    - [[Waterfall Model (SDLC)]]
      - Software development started as a slow, cautious, and methodical practice that followed a sequence of steps aimed at delivering perfect products.
      - Predominant between 1960s and 1980s.
      - The Waterfall model is known for its inflexible, process-oriented, and sequential nature.
      - Extensive and time-consuming planning and approvals
    - [[Extreme Programming (XP)]]
      - Reinforced the concept that tests should be written to describe how code should work, which was also the center of [[Test-Driven Development (TDD)]] practices.
      - The early 1990s
      - [[The Agile Manifesto]]
        - The [[Agile Aliance]] was formed
  - [[Continuous Integration (CI)]]
    - Automated processes should be in place to test and build software many times a day.
      - Important because bugs are commonly introduced at the intersection or integration of two different pieces of code
  - [[Continuous Delivery (CD)]]
    - CD follows in the footsteps of CI.
    - It focuses on gathering all changes to code—such as new features, bug fixes, and configuration changes—and sending them to users—or production—as safely, sustainably, and quickly as possible.
  - Introduction to GitHub: creating a user account
    - Creating a free user account on [[GitHub]]
    - Creating a [[Personal Access Token (PAT)]]
      - Settings -> Token
    - About SSH Keys
    - Checking for existing SSH keys
      - `ls -al ~/.ssh`
    - Creating an SSH key
      - `ssh-keygen -t ed25519 -C "your_email@example.com"`
    - Adding the SSH key to the [[ssh-agent]]
    - Adding your SSH key to your [[GitHub]] user account
  - Discovering the basics of [[Git]] and [[GitHub]]
    - Configuring [[Git]]
    - Basic [[Git]] commands
    - Basics of [[GitHub]]
    - Pull requests
    - Settings
      - Allows us to configure most features within a repository.
        - Branches
        - Actions
          - Related to [[GitHub Actions]]
        - Secrets
  - Introduction to [[YAML]]
    - [[GitHub Actions]] must be written using the [[YAML]] syntax.
      - https://github.com/actions/starter-workflows
    - Basic rules
      - Key-value pairs and case sensitivity
      - Indentation and the use of tabs
      - Comments
    - [[YAML]] components
      - Scalars
      - Sequences
      - Mappings
- Chapter 2 - Deep Diving into [[GitHub Actions]]
  - Learning about GitHub Actions' core concepts and components
    - Events
      - GitHub Actions are event-driven.
      - Workflows can be triggered by 3 groups of events
        - Scheduled events
          - Trigger a workflow run at a specified time.
          - They use [[POSIX cron syntax]]
          - Scheduled events run on the latest commit on the default branch.
          - Example:
            - Trigger every 5 minutes (the shortest interval we can schedule intervals for)
              - ```yaml
                on:
                  schedule:
                    - cron: '*/5 * * * *'
                ```
        - Manual events
          - 2 types of manual events
            - `workflow_dispatch`
              - Used to trigger specific workflows within the repository on GitHub manually.
              - It also allows us to define custom input properties, as well as default and required inputs.
              - To trigger the `workflow_dispatch` event, the workflow must be on the default branch.
              - Example
                - ```yaml
                  on:
                    workflow_dispatch:
                      inputs:
                        username:
                          description: 'Your GitHub username'
                          required: true
                        reason:
                          description: 'Why are you running this workflow manually?'
                          required: true
                          default: 'I am running tests before implementing an automated workflow'
                  ```
            - `repository_dispatch`
              - The workflow can happen in different repositories or in environment outside GitHub.
              - To trigger this event, we must use the GitHub API and send a POST request that provides an `event_type` name that we will describe the activity type.
                - Example
                  - ```sh
                    curl -X POST -H "Accept: application/vnd.github.v3+json" https://api.github.com/repos/octocat/hello-world/dispatches -d '{"event_type":"event_type"}'
                    ```
              - We will need to use the [[Personal Access Token (PAT)]].
        - Webhook events
          - Trigger a workflow when GitHub webhook events - such as issue and pull request creation, update, and deletion, deployment, page_build, and others - are created.
      - Jobs
        - A set of steps that run on the same runner.
        - Multiple jobs within the same workflow can run sequentially, although by default, they will run in parallel.
        - Example
          - ```yaml
            jobs:
              tests_manual_workflow:
                runs-on: ubuntu-latest
            ```
      - Steps
        - Individual tasks that can run commands.
        - Steps can share data among themselves because is step in a given job runs on the same runner.
        - Example
          - ```yaml
            steps:
              - run: >
                  echo "User ${{ github.event.inputs.username }} ran a workflow manually."
                  echo "Because ${{ github.event.inputs.reason }}."
            ```
      - Actions
        - Standalone commands that can be portable.
        - Combined into steps to create a job.
        - Example
          - ```yaml
            jobs:
              stale:
                runs-on: ubuntu-latest
                steps:
                  - uses: actions/stale@v3
            ```
      - Runners
        - A runner is a server application, often installed on a virtual machine or Docker container, that runs a job from a GitHub Actions workflow.
        - In general, a runner runs one job at a time and reports its progress to GitHub.
        - While each job in a workflow executes on a fresh instance of the virtual machine, all the steps in a job execute in the same instance of the virtual machine. This allows the actions within that job to share information using the filesystem.
        - Two types of runners
          - GitHub-hosted runners
            - Available: Windows, Mac, Ubuntu
            - GitHub provides specific, case-sensitive environment variables that we should use to access the file system, rather than using hardcoded paths.
              - home
                - `HOME`
              - workspace
                - `GITHUB_WORKSPACE`
              - workflow
                - `GITHUB_EVENT_PATH`
            - Each VM, independently of the OS, has the same hardware resources: a 2-core CPU, 7 GB of RAM, 14 GB of SSD disk space.
          - Self-hosted runners
  - Understanding the basics of workflows
    - Workflow configuration is defined in a workflow file, which must be written using YAML.
    - All workflow files related to GitHub Actions must live in the `.github/workflows` directory and must have either the `.yml` or `.yaml` file extension.
    - Learning the basics of the workflow file syntax
      - `name`
        - Optional
      - `on`
        - Required
        - Which event or events will trigger the workflow.
      - `jobs`
        - Workflow runs can have one or more jobs.
        - Example
          - ```yaml
            jobs:
              jobA:
              jobB:
                needs: jobA
              jobC:
                needs: [jobA, jobB]
            ```
        - `job_id`
          - Each job must have a `job_id` associated with it.
          - Must be strings that contain only alphanumeric characters.
          - Must start with either an `_` or letter and must be unique to that specific job.
        - `needs`
          - Optional
          - Requirements before running job
        - `runs_on`
          - Required
          - Example
            - ```yaml
              runs-on:
              	self-hosted
              ```
        - `steps`
          - Tasks that exist within a job.
          - Example
            - ```yaml
              steps:
                - run: >
                    echo "User ${{ github.event.inputs.username }} ran a workflow manually."
                    echo "Because ${{ github.event.inputs.reason }}."
              ```
        - `uses`
          - Use an existing action.
  - Securing your GitHub Actions
- Chapter 3 - a closer look at workflows
- Chapter 4 - working with self-hosted runners
- Chapter 5 - writing your own actions
- Chapter 6 - marketplace: finding existing actions and publishing your owns
- Chapter 7 - migrations
- Chapter 8 - contributing to the community and finding help
- Chapter 9 - the future of [[GitHub Actions]]
