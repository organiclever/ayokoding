CC = gcc
CFLAGS = -Wall -Wextra -g
TARGET_DIR = ../target/$(notdir $(CURDIR))

SRCS = $(wildcard *.c */*.c)
OBJS = $(addprefix $(TARGET_DIR)/, $(SRCS:.c=.o))
TARGET = $(TARGET_DIR)/program

.PHONY: all clean run

all: $(TARGET)

$(TARGET): $(OBJS)
	$(CC) $(CFLAGS) $^ -o $@

$(TARGET_DIR)/%.o: %.c
	@mkdir -p $(dir $@)
	$(CC) $(CFLAGS) -c $< -o $@

build: $(TARGET)

run: $(TARGET)
	$(TARGET)

clean:
	rm -rf $(TARGET_DIR)
